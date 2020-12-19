#----------------------------------------------------------------
# Generated CMake target import file for configuration "Debug".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Boden::lottieview" for configuration "Debug"
set_property(TARGET Boden::lottieview APPEND PROPERTY IMPORTED_CONFIGURATIONS DEBUG)
set_target_properties(Boden::lottieview PROPERTIES
  IMPORTED_LOCATION_DEBUG "${_IMPORT_PREFIX}/lib/liblottieview.so"
  IMPORTED_SONAME_DEBUG "liblottieview.so"
  )

list(APPEND _IMPORT_CHECK_TARGETS Boden::lottieview )
list(APPEND _IMPORT_CHECK_FILES_FOR_Boden::lottieview "${_IMPORT_PREFIX}/lib/liblottieview.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
