#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::foundation_android" for configuration "Release"
set_property(TARGET Boden::foundation_android APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(Boden::foundation_android PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib/libfoundation_android.so"
  IMPORTED_SONAME_RELEASE "libfoundation_android.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::foundation_android )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::foundation_android "${_IMPORT_PREFIX}/lib/libfoundation_android.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
