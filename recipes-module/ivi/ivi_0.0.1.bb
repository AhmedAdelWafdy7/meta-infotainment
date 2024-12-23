SUMMARY = "In-Vehicle Infotainment made by Qt5"

LICENSE = "CLOSED"


SRC_URI = "git://github.com/AhmedAdelWafdy7/Infotainment-System.git;protocol=https;branch=main"
SRCREV = "5d9b806665543ce0dc7c4529a29b993a29c1a9c3"



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
           qtwayland \
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
    cp -r ${S}/can-setup.sh ${D}${bindir}/pdc
}
