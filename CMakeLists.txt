cmake_minimum_required(VERSION 3.6)

set( CMAKE_CXX_STANDARD 17 )
set( CMAKE_POSITION_INDEPENDENT_CODE ON )

set(BDN_BUILD_TESTS OFF CACHE BOOL "Don't include boden tests")
set(BDN_BUILD_EXAMPLES OFF CACHE BOOL "Don't include boden examples")
set(BDN_WARNINGS_AS_ERRORS OFF CACHE BOOL "Don't treat warnings as errors")

project(MyFinances)

add_subdirectory(.. boden)

file(GLOB_RECURSE _sources source/*.cpp source/*.h)

ios_configure_asset(_assets ./ios-assets/Base.lproj/LaunchScreen.storyboard)
ios_configure_asset(_assets DemoIcon/black.png)

roger_add(
    MyFinances
    _assets
    ${CMAKE_CURRENT_LIST_DIR}/DemoIcon/demo_icon.json)

set(ANDROID_ICON "android:icon=\"@mipmap/ic_launcher_png\"")

add_universal_executable(MyFinances SOURCES ${_sources} ${_assets})

ios_configure_app_info(TARGET MyFinances
    LAUNCHSCREEN "LaunchScreen"
    TARGETED_DEVICES IPHONE IPAD
    IPHONE_ORIENTATIONS ALL
    IPAD_ORIENTATIONS ALL)

use_boden_template_info_plist(
    TARGET MyFinances
    BUNDLE_NAME "MyFinances"
    BUNDLE_ID "io.mycompany.MyFinances"
    )
set(ANDROID_APP_ID "io.mycompany.MyFinances")

set_xcode_appicon_asset(MyFinances "ApplicationIcon")
use_boden_template_info_plist(TARGET MyFinances
                              BUNDLE_NAME "MyFinances"
                              BUNDLE_ID "com.mycompany.MyFinances")

set_target_version(TARGET MyFinances VERSION "1.0.0" SHORTVERSION "1.0" LONGVERSION "1.0.0.0" ANDROID_VERSION_ID 1)

target_link_libraries(MyFinances Boden::All)
