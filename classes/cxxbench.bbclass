LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"
SRC_URI = "git://cube:20022/var/git/repositories/cxxbench.git;protocol=ssh;branch=development;user=git"

S = "${WORKDIR}/git"

CXXBENCH_SYSTEM_TUNE_FLAGS ?= ""
CXXBENCH_DEFAULT_FLAGS ?= "-std=c++14 -O2"

EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release -DCMAKE_CXX_FLAGS_RELEASE='${CXXBENCH_SYSTEM_TUNE_FLAGS} ${CXXBENCH_DEFAULT_FLAGS} -DNDEBUG'"

inherit cmake

do_patch() {
   pushd ${S}
   git reset --hard
   sed -e "s/cxxbench/${PN}/g" "CMakeLists.txt" > "CMakeLists.txt.bak"
   mv -f "CMakeLists.txt.bak" "CMakeLists.txt"
   popd
}
