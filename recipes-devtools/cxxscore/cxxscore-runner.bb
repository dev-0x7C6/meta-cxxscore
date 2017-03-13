LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://${PN}.sh"
FILES_${PN} += "${bindir}/${PN}.sh"
RDEPENDS_${PN} += "bash cpufrequtils"

do_install() {
	mkdir -p ${D}${bindir}
	install -m 755 ${WORKDIR}/${PN}.sh ${D}${bindir}/
}
