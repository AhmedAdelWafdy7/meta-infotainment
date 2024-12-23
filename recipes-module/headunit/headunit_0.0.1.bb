SUMMARY = "Head Unit made by Qt5"

LICENSE = "CLOSED"



SRC_URI = "git://github.com/AhmedAdelWafdy7/Infotainment-System.git;protocol=https;branch=headunit"
SRCREV = "331932f474bb07cf6b64a0e65df3ef184d88a2a4"

S = "${WORKDIR}/git"

inherit cmake_qt5


DEPENDS = " \
           common-api-c++ \
           vsomeip \
           common-api-c++-someip \
           qtbase \
           qtdeclarative \
           qtquickcontrols \
           qtquickcontrols2 \
           qtmultimedia \
           python3 \
           qtserialbus \
           qtgraphicaleffects \
           qt3d \
           qtlocation \
"

EXTRA_OECMAKE += " \
                -DCMAKE_INCLUDE_PATH=${STAGING_INCDIR} \
                -DCMAKE_LIBRARY_PATH=${STAGING_LIBDIR} \
"

do_install:append() {
    cp -r ${S}/can-setup.sh ${D}${bindir}/headunit
}
