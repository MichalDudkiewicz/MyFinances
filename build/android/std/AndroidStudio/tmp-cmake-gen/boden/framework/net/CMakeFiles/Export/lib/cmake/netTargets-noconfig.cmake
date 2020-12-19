#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::net" for configuration ""
set_property(TARGET Boden::net APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(Boden::net PROPERTIES
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libnet.so"
  IMPORTED_SONAME_NOCONFIG "libnet.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::net )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::net "${_IMPORT_PREFIX}/lib/libnet.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
