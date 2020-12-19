# This file will be configured to contain variables for CPack. These variables
# should be set in the CMake list file of the project before CPack module is
# included. The list of available CPACK_xxx variables and their associated
# documentation may be obtained using
#  cpack --help-variable-list
#
# Some variables are common to all generators (e.g. CPACK_PACKAGE_NAME)
# and some are specific to a generator
# (e.g. CPACK_NSIS_EXTRA_INSTALL_COMMANDS). The generator specific variables
# usually begin with CPACK_<GENNAME>_xxxx.


set(CPACK_BINARY_DEB "OFF")
set(CPACK_BINARY_FREEBSD "OFF")
set(CPACK_BINARY_IFW "OFF")
set(CPACK_BINARY_NSIS "OFF")
set(CPACK_BINARY_RPM "OFF")
set(CPACK_BINARY_STGZ "ON")
set(CPACK_BINARY_TBZ2 "OFF")
set(CPACK_BINARY_TGZ "ON")
set(CPACK_BINARY_TXZ "OFF")
set(CPACK_BINARY_TZ "ON")
set(CPACK_BUILD_SOURCE_DIRS "/home/dudkiewm/boden/MyFinances;/home/dudkiewm/boden/MyFinances/build/android/std/AndroidStudio/MyFinances/.externalNativeBuild/cmake/debug/x86")
set(CPACK_CMAKE_GENERATOR "Ninja")
set(CPACK_COMPONENTS_ALL "ANDROID;Android;Library;Unspecified")
set(CPACK_COMPONENT_UNSPECIFIED_HIDDEN "TRUE")
set(CPACK_COMPONENT_UNSPECIFIED_REQUIRED "TRUE")
set(CPACK_DEFAULT_PACKAGE_DESCRIPTION_FILE "/home/dudkiewm/.local/lib/python3.6/site-packages/cmake/data/share/cmake-3.18/Templates/CPack.GenericDescription.txt")
set(CPACK_DEFAULT_PACKAGE_DESCRIPTION_SUMMARY "MyFinances built using CMake")
set(CPACK_GENERATOR "STGZ;TGZ;TZ")
set(CPACK_INSTALL_CMAKE_PROJECTS "/home/dudkiewm/boden/MyFinances/build/android/std/AndroidStudio/MyFinances/.externalNativeBuild/cmake/debug/x86;MyFinances;ALL;/")
set(CPACK_INSTALL_PREFIX "/usr/local")
set(CPACK_MODULE_PATH "")
set(CPACK_NSIS_DISPLAY_NAME "MyFinances 0.3.0")
set(CPACK_NSIS_INSTALLER_ICON_CODE "")
set(CPACK_NSIS_INSTALLER_MUI_ICON_CODE "")
set(CPACK_NSIS_INSTALL_ROOT "$PROGRAMFILES")
set(CPACK_NSIS_PACKAGE_NAME "MyFinances 0.3.0")
set(CPACK_NSIS_UNINSTALL_NAME "Uninstall")
set(CPACK_OUTPUT_CONFIG_FILE "/home/dudkiewm/boden/MyFinances/build/android/std/AndroidStudio/MyFinances/.externalNativeBuild/cmake/debug/x86/CPackConfig.cmake")
set(CPACK_PACKAGE_DEFAULT_LOCATION "/")
set(CPACK_PACKAGE_DESCRIPTION_FILE "/home/dudkiewm/.local/lib/python3.6/site-packages/cmake/data/share/cmake-3.18/Templates/CPack.GenericDescription.txt")
set(CPACK_PACKAGE_DESCRIPTION_SUMMARY "MyFinances built using CMake")
set(CPACK_PACKAGE_FILE_NAME "boden-0.3.0-android-x86-23-Debug-Clang")
set(CPACK_PACKAGE_INSTALL_DIRECTORY "MyFinances 0.3.0")
set(CPACK_PACKAGE_INSTALL_REGISTRY_KEY "MyFinances 0.3.0")
set(CPACK_PACKAGE_NAME "MyFinances")
set(CPACK_PACKAGE_RELOCATABLE "true")
set(CPACK_PACKAGE_VENDOR "Humanity")
set(CPACK_PACKAGE_VERSION "0.3.0")
set(CPACK_PACKAGE_VERSION_MAJOR "0")
set(CPACK_PACKAGE_VERSION_MINOR "3")
set(CPACK_PACKAGE_VERSION_PATCH "0")
set(CPACK_PROJECT_CONFIG_FILE "/home/dudkiewm/boden/package/generator.cmake")
set(CPACK_RESOURCE_FILE_LICENSE "/home/dudkiewm/.local/lib/python3.6/site-packages/cmake/data/share/cmake-3.18/Templates/CPack.GenericLicense.txt")
set(CPACK_RESOURCE_FILE_README "/home/dudkiewm/.local/lib/python3.6/site-packages/cmake/data/share/cmake-3.18/Templates/CPack.GenericDescription.txt")
set(CPACK_RESOURCE_FILE_WELCOME "/home/dudkiewm/.local/lib/python3.6/site-packages/cmake/data/share/cmake-3.18/Templates/CPack.GenericWelcome.txt")
set(CPACK_SET_DESTDIR "OFF")
set(CPACK_SOURCE_GENERATOR "TBZ2;TGZ;TXZ;TZ")
set(CPACK_SOURCE_OUTPUT_CONFIG_FILE "/home/dudkiewm/boden/MyFinances/build/android/std/AndroidStudio/MyFinances/.externalNativeBuild/cmake/debug/x86/CPackSourceConfig.cmake")
set(CPACK_SOURCE_RPM "OFF")
set(CPACK_SOURCE_TBZ2 "ON")
set(CPACK_SOURCE_TGZ "ON")
set(CPACK_SOURCE_TXZ "ON")
set(CPACK_SOURCE_TZ "ON")
set(CPACK_SOURCE_ZIP "OFF")
set(CPACK_SYSTEM_NAME "Android")
set(CPACK_TOPLEVEL_TAG "Android")
set(CPACK_WIX_SIZEOF_VOID_P "4")

if(NOT CPACK_PROPERTIES_FILE)
  set(CPACK_PROPERTIES_FILE "/home/dudkiewm/boden/MyFinances/build/android/std/AndroidStudio/MyFinances/.externalNativeBuild/cmake/debug/x86/CPackProperties.cmake")
endif()

if(EXISTS ${CPACK_PROPERTIES_FILE})
  include(${CPACK_PROPERTIES_FILE})
endif()

# Configuration for component group "boden_root"
set(CPACK_COMPONENT_GROUP_BODEN_ROOT_DISPLAY_NAME "Boden")
set(CPACK_COMPONENT_GROUP_BODEN_ROOT_DESCRIPTION "The boden Framework")

# Configuration for component group "boden_framework"
set(CPACK_COMPONENT_GROUP_BODEN_FRAMEWORK_DISPLAY_NAME "Framework")
set(CPACK_COMPONENT_GROUP_BODEN_FRAMEWORK_DESCRIPTION "Contains the boden Framework")
set(CPACK_COMPONENT_GROUP_BODEN_FRAMEWORK_PARENT_GROUP "boden_root")

# Configuration for component group "boden_tests"
set(CPACK_COMPONENT_GROUP_BODEN_TESTS_DISPLAY_NAME "Unit tests")
set(CPACK_COMPONENT_GROUP_BODEN_TESTS_DESCRIPTION "Contains the boden Framework Unittests")
set(CPACK_COMPONENT_GROUP_BODEN_TESTS_PARENT_GROUP "boden_root")

# Configuration for component group "boden_examples"
set(CPACK_COMPONENT_GROUP_BODEN_EXAMPLES_DISPLAY_NAME "Examples")
set(CPACK_COMPONENT_GROUP_BODEN_EXAMPLES_DESCRIPTION "Contains the boden Framework Examples")
set(CPACK_COMPONENT_GROUP_BODEN_EXAMPLES_PARENT_GROUP "boden_root")

# Configuration for component "library"

SET(CPACK_COMPONENTS_ALL ANDROID Android Library Unspecified)
set(CPACK_COMPONENT_LIBRARY_DISPLAY_NAME "Library")
set(CPACK_COMPONENT_LIBRARY_DESCRIPTION "The boden framework")
set(CPACK_COMPONENT_LIBRARY_GROUP boden_framework)
set(CPACK_COMPONENT_LIBRARY_INSTALL_TYPES all libonly)
set(CPACK_COMPONENT_LIBRARY_REQUIRED TRUE)

# Configuration for component "tests"

SET(CPACK_COMPONENTS_ALL ANDROID Android Library Unspecified)
set(CPACK_COMPONENT_TESTS_DISPLAY_NAME "Unit tests")
set(CPACK_COMPONENT_TESTS_DESCRIPTION "The boden unittests")
set(CPACK_COMPONENT_TESTS_GROUP boden_tests)
set(CPACK_COMPONENT_TESTS_DEPENDS library)
set(CPACK_COMPONENT_TESTS_INSTALL_TYPES all)

# Configuration for component "examples"

SET(CPACK_COMPONENTS_ALL ANDROID Android Library Unspecified)
set(CPACK_COMPONENT_EXAMPLES_DISPLAY_NAME "Examples")
set(CPACK_COMPONENT_EXAMPLES_DESCRIPTION "The boden examples")
set(CPACK_COMPONENT_EXAMPLES_GROUP boden_examples)
set(CPACK_COMPONENT_EXAMPLES_DEPENDS library)
set(CPACK_COMPONENT_EXAMPLES_INSTALL_TYPES all)

# Configuration for installation type "all"
list(APPEND CPACK_ALL_INSTALL_TYPES all)
set(CPACK_INSTALL_TYPE_ALL_DISPLAY_NAME "Everything")

# Configuration for installation type "libonly"
list(APPEND CPACK_ALL_INSTALL_TYPES libonly)
set(CPACK_INSTALL_TYPE_LIBONLY_DISPLAY_NAME "Library Only")
