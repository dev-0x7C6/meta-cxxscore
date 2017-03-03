LICENSE = "CLOSED"

SERVICE_NAME = "${PN}.service"

SRCREV = "${AUTOREV}"
SRC_URI = "git://cube:20022/var/git/repositories/compiler-benchmark-platform.git;protocol=ssh;branch=development;user=git"
SRC_URI += "file://${SERVICE_NAME}"

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "${SERVICE_NAME}"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/${SERVICE_NAME} ${D}${systemd_unitdir}/system
}
