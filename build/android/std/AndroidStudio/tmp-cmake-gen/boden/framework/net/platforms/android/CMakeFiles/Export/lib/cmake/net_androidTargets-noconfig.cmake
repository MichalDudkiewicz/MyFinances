#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::net_android" for configuration ""
set_property(TARGET Boden::net_android APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(Boden::net_android PROPERTIES
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libnet_android.so"
  IMPORTED_SONAME_NOCONFIG "libnet_android.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::net_android )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::net_android "${_IMPORT_PREFIX}/lib/libnet_android.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
