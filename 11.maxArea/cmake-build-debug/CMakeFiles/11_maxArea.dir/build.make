# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\SoftWare\CLion 2021.2.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\SoftWare\CLion 2021.2.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Data\LeetCode\11.maxArea

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Data\LeetCode\11.maxArea\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/11_maxArea.dir/depend.make
# Include the progress variables for this target.
include CMakeFiles/11_maxArea.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/11_maxArea.dir/flags.make

CMakeFiles/11_maxArea.dir/main.cpp.obj: CMakeFiles/11_maxArea.dir/flags.make
CMakeFiles/11_maxArea.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Data\LeetCode\11.maxArea\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/11_maxArea.dir/main.cpp.obj"
	C:\SoftWare\MinGW\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\11_maxArea.dir\main.cpp.obj -c C:\Data\LeetCode\11.maxArea\main.cpp

CMakeFiles/11_maxArea.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/11_maxArea.dir/main.cpp.i"
	C:\SoftWare\MinGW\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Data\LeetCode\11.maxArea\main.cpp > CMakeFiles\11_maxArea.dir\main.cpp.i

CMakeFiles/11_maxArea.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/11_maxArea.dir/main.cpp.s"
	C:\SoftWare\MinGW\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Data\LeetCode\11.maxArea\main.cpp -o CMakeFiles\11_maxArea.dir\main.cpp.s

# Object files for target 11_maxArea
11_maxArea_OBJECTS = \
"CMakeFiles/11_maxArea.dir/main.cpp.obj"

# External object files for target 11_maxArea
11_maxArea_EXTERNAL_OBJECTS =

11_maxArea.exe: CMakeFiles/11_maxArea.dir/main.cpp.obj
11_maxArea.exe: CMakeFiles/11_maxArea.dir/build.make
11_maxArea.exe: CMakeFiles/11_maxArea.dir/linklibs.rsp
11_maxArea.exe: CMakeFiles/11_maxArea.dir/objects1.rsp
11_maxArea.exe: CMakeFiles/11_maxArea.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Data\LeetCode\11.maxArea\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable 11_maxArea.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\11_maxArea.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/11_maxArea.dir/build: 11_maxArea.exe
.PHONY : CMakeFiles/11_maxArea.dir/build

CMakeFiles/11_maxArea.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\11_maxArea.dir\cmake_clean.cmake
.PHONY : CMakeFiles/11_maxArea.dir/clean

CMakeFiles/11_maxArea.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Data\LeetCode\11.maxArea C:\Data\LeetCode\11.maxArea C:\Data\LeetCode\11.maxArea\cmake-build-debug C:\Data\LeetCode\11.maxArea\cmake-build-debug C:\Data\LeetCode\11.maxArea\cmake-build-debug\CMakeFiles\11_maxArea.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/11_maxArea.dir/depend

