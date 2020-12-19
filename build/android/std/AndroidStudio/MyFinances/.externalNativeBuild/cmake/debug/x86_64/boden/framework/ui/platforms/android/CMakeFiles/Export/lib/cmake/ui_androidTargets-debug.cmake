#----------------------------------------------------------------
# Generated CMake target import file for configuration "Debug".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::ui_android" for configuration "Debug"
set_property(TARGET Boden::ui_android APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(Boden::ui_android PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/lib/libui_android.so"
  IMPORTED_SONAME_DEBUG "libui_android.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::ui_android )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::ui_android "${_IMPORT_PREFIX}/lib/libui_android.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
