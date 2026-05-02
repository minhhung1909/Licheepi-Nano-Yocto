SUMMARY = "PPP configuration for SIMCom A7670C"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://simcom-peer \
    file://simcom-chat \
"

do_install() {
    install -d ${D}${sysconfdir}/ppp/peers
    install -d ${D}${sysconfdir}/ppp/chatscripts

    install -m 0644 ${WORKDIR}/simcom-peer ${D}${sysconfdir}/ppp/peers/simcom
    install -m 0644 ${WORKDIR}/simcom-chat ${D}${sysconfdir}/ppp/chatscripts/simcom
}

FILES_${PN} += "${sysconfdir}/ppp/peers/simcom"
FILES_${PN} += "${sysconfdir}/ppp/chatscripts/simcom"
