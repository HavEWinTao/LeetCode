import os
import shutil

if __name__ == '__main__':
    path1 = os.getcwd()
    dirs = os.listdir(path1)
    for item in dirs:
        item = path1 + "\\" + item
        if os.path.isdir(item):
            files = os.listdir(item)
            for cache in files:
                if (cache == "cmake-build-debug") or (cache == ".idea"):
                    path = item + "\\" + cache
                    shutil.rmtree(path)
