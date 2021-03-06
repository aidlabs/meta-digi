#
# Copyright (C) 2012 Digi International.
#
SUMMARY = "Bluetooth packagegroup for DEY image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit bluetooth
inherit packagegroup

RDEPENDS_${PN} = " \
	${BLUEZ} \
	${BLUEZ}-testtools \
	${@bb.utils.contains("MACHINE_FEATURES", "bluetooth", "libasound-module-bluez", "", d)} \
	${@bb.utils.contains("BLUEZ", "bluez5", "bluez5-noinst-tools bluez5-obex", "", d)} \
"
