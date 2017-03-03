LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "kernel-modules"

CXXBENCH_GCC_RUNTIME = " cxxbench-gcc-o1 cxxbench-gcc-o2 cxxbench-gcc-o3 cxxbench-gcc-os" 
CXXBENCH_CLANG_RUNTIME = " cxxbench-clang-o1 cxxbench-clang-o2 cxxbench-clang-o3 cxxbench-clang-os" 

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gdb \
    gdbserver \
    gettext \
    git \
    clang \
    ldd \
    libstdc++ \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-modules \
    python3-modules \
    python3-pydoc \
"

IMAGE_INSTALL += " ${DEV_SDK_INSTALL}"
IMAGE_INSTALL += " ${CXXBENCH_GCC_RUNTIME}"
IMAGE_INSTALL += " ${CXXBENCH_CLANG_RUNTIME}"

DEPENDS += "bcm2835-bootfiles"

set_default_machineid() {
    echo "76465eef8ce3465699b148cfc37548d0" > ${IMAGE_ROOTFS}/etc/machine-id
}

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    set_default_machineid ; \
 "
