LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "kernel-modules"

IMAGE_INSTALL += " cxxbench-gcc-o2 cxxbench-gcc-o3 cxxbench-gcc-os"
IMAGE_INSTALL += " cxxbench-clang-o2 cxxbench-clang-o3 cxxbench-clang-os"
IMAGE_INSTALL += " cxxbench-runner util-linux"

set_default_machineid() {
    echo "76465eef8ce3465699b148cfc37548d0" > ${IMAGE_ROOTFS}/etc/machine-id
}

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Warsow ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    set_default_machineid ; \
 "
