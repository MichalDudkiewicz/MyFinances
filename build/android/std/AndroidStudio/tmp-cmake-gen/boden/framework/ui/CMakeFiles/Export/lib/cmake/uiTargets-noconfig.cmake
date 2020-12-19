#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::ui" for configuration ""
set_property(TARGET Boden::ui APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(Boden::ui PROPERTIES
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libui.so"
  IMPORTED_SONAME_NOCONFIG "libui.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::ui )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::ui "${_IMPORT_PREFIX}/lib/libui.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
