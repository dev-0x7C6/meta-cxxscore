LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += " \
	cpufrequtils \
	cxxscore-clang-o2 \
	cxxscore-clang-o3 \
	cxxscore-clang-os \
	cxxscore-gcc-o2 \
	cxxscore-gcc-o3 \
	cxxscore-gcc-os \
	cxxscore-runner \
	htop \
	kernel-modules \
	mc \
	util-linux \
"
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
