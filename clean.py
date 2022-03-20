import os
import re
import shutil

if __name__ == '__main__':
    path1 = os.getcwd()
    dirs = os.listdir(path1)
    for item in dirs:
        item = path1 + "\\" + item
        if os.path.isdir(item):
            files = os.listdir(item)
            for cache in files:
                path = item + "\\" + cache
                if (cache == "cmake-build-debug") or (cache == ".idea"):
                    shutil.rmtree(path)
                if re.match('.*.iml', cache) is not None:
                    if cache != 'LeetCode.iml':
                        os.remove(path)
                if cache == 'src':
                    codes = os.listdir(path)
                    for code in codes:
                        filename0 = os.path.splitext(code)[0]
                        filename1 = os.path.splitext(code)[1]
                        despath = item + "\\" + filename0 + filename1
                        shutil.move(path + "\\" + code, despath)
                    shutil.rmtree(path)
