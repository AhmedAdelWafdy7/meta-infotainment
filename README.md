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
