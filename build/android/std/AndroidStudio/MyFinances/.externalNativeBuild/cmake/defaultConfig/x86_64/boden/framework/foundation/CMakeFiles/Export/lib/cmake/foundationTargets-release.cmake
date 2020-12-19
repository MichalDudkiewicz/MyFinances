#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::foundation" for configuration "Release"
set_property(TARGET Boden::foundation APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(Boden::foundation PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib/libfoundation.so"
  IMPORTED_SONAME_RELEASE "libfoundation.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::foundation )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::foundation "${_IMPORT_PREFIX}/lib/libfoundation.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
