# meta-infotainment

This is the layer for **Infotainment System** fit in OpenEmbedded/Yocto

Details of **Infotainment System**, go to In [**Infotainment System**](https://github.com/AhmedAdelWafdy7/Infotainment-System)

# Dependencies

This layer depends on:

- URI: [https://github.com/yoctoproject/poky](https://github.com/yoctoproject/poky)
    - branch : kirkstone
    - revision : 4.0.12
- URI: [git://git.openembedded.org/meta-openembedded](https://git.openembedded.org/meta-openembedded//)
    - branch : kirkstone
    - commit : 8a75c61cce2aa1d6e5a3597ab8fc5a7ee6aeae1e4
- URI: [https://github.com/agherzan/meta-raspberrypi](https://github.com/agherzan/meta-raspberrypi.git)
    - branch : master
    - commit : 59a6a1b5dd1e21189adec49c61eae04ed3e70338
- URI: [https://github.com/meta-qt5/meta-qt5](https://github.com/meta-qt5/meta-qt5.git)
    - branch : kirkstone
    - commit : ae8a97f79364bed1abc297636f7933d0e35f22be


## add to local.conf

```
MACHINE ??= "raspberrypi4-64"



BB_NUMBER_THREADS = "4"
PARALLEL_MAKE:qt3d = "-j2"
LICENSE_FLAGS_ACCEPTED += "commercial"


# Setting for camera in wayland compositor
PACKAGECONFIG:remove:pn-qtwayland = "xcomposite-glx"
VIDEO_CAMERA = "1"

# Setting for CAN 2-CH FD
KERNEL_DEVICETREE:append = " \
                        overlays/mcp251xfd.dtbo \
"

# Setting for i2c
ENABLE_I2C = "1"
KERNEL_MODULE_AUTOLOAD:rpi += "i2c-dev i2c-bcm2708"


# Set systemd instead sysV
DISTRO_FEATURES:append = " systemd"
DISTRO_FEATURES:remove = "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
DISTRO_FEATURES_BACKFIL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_initscript = "systemd-compat-units"

# Set wayland for Qt
DISTRO_FEATURES:remove = "x11 vulkan"
DISTRO_FEATURES:append = " wayland"
CORE_IMAGE_EXTRA_INSTALL = "wayland"

# Ignore old license error
LICENSE_FLAGS_ACCEPTED += "synaptics-killswitch"

# Set for qt5 gstreamer
LICENSE_FLAGS_ACCEPTED += "commercial"
PACKAGECONFIG:append_pn-qtmultimedia=" gstreamer1.0"
PACKAGECONFIG:append_pn-gstreamer1.0-plugins-bad = " hls"

IMAGE_FSTYPES = "tar.xz ext3 rpi-sdimg"

```


# Details

1. recipes-connectivity & recipes kernel
    - Files for match poky(kirkstone) and meta-rapsberrypi(master)
    - Refer meta-raspberrypi [issue #1211](https://github.com/agherzan/meta-raspberrypi/issues/1211)
2. recipes-env
    - Basic setting for run our ivi app
    - Install qt5, wifi, raspi-config etc
3. recipes-ipc
    - Module for IPC(vsomeip)
    - We have to downgrade boost version for particular version of commonapi
4. recipes-pypi
    - Install piracer and dependent pip packages
    - Use setuptools3
5. recipes-module
    - Apps that we made. Including headunit & ivi
    - Supervisor is for auto start and managing the process
6. recipes-core
    - Main bb files for making our image

# References

- [Yocto Project](https://docs.yoctoproject.org/4.0.12/migration-guides/migration-4.0.html)
- [Meta-raspberrypi](https://meta-raspberrypi.readthedocs.io/en/latest/index.html)
- [Meta-Qt](https://koansoftware.com/pub/talks/QtDay-2019/QtDay2019-Koan.pdf)
- [Meta-Openembedded](https://layers.openembedded.org/layerindex/branch/master/layers/)
