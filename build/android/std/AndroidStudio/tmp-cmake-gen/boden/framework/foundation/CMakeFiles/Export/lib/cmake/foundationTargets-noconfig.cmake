#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::foundation" for configuration ""
set_property(TARGET Boden::foundation APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(Boden::foundation PROPERTIES
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libfoundation.so"
  IMPORTED_SONAME_NOCONFIG "libfoundation.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::foundation )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::foundation "${_IMPORT_PREFIX}/lib/libfoundation.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
