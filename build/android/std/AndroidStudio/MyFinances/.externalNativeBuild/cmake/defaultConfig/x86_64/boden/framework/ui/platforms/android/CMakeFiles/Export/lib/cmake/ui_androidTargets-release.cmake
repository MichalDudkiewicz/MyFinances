#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::ui_android" for configuration "Release"
set_property(TARGET Boden::ui_android APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(Boden::ui_android PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib/libui_android.so"
  IMPORTED_SONAME_RELEASE "libui_android.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::ui_android )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::ui_android "${_IMPORT_PREFIX}/lib/libui_android.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
