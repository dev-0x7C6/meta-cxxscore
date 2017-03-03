LICENSE = "CLOSED"

INSTALL_PATH_MATCH = "cxxbench"
INSTALL_PATH_PATCH = "${PN}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://cube:20022/var/git/repositories/compiler-benchmark-platform.git;protocol=ssh;branch=development;user=git"

S = "${WORKDIR}/git"

CMAKE_CXX_FLAGS_RELEASE ?= "-std=c++14 -march=native -O2"

EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_FLAGS_RELEASE='${CMAKE_CXX_FLAGS_RELEASE}'"

inherit cmake

do_patch() {
   pushd ${S}
   sed "s@${INSTALL_PATH_MATCH}@${INSTALL_PATH_PATCH}@g" "CMakeLists.txt" > "CMakeLists.txt.mod"
   cp -fv "CMakeLists.txt.mod" "CMakeLists.txt"
   popd
}
