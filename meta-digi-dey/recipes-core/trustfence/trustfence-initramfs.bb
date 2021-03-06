# Copyright (C) 2016 Digi International.

SUMMARY = "Trustfence initramfs required files"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
    file://trustfence-initramfs-init \
    file://trustfence-install.sh \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 trustfence-initramfs-init ${D}/init
	install -m 0755 trustfence-install.sh ${D}${base_sbindir}
}

# Do not create debug/devel packages
PACKAGES = "${PN}"

FILES_${PN} = "/"

# Runtime packages used in 'trustfence-initramfs-init'
RDEPENDS_${PN} = " \
    trustfence-tool \
    util-linux-findfs \
    wipe \
    u-boot-fw-utils \
"

RDEPENDS_${PN}_append_ccimx6sbc = " \
    cryptsetup \
    rng-tools \
"

RDEPENDS_${PN}_append_ccimx6ul = " \
    mtd-utils-ubifs \
"
