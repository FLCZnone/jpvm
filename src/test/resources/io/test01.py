#测试文件打开关闭
import io
fr = io.open("test01.txt", 'r')
io.close(fr)
fw = io.open("test01.txt", 'w')
io.close(fw)
fa = io.open("test01.txt", 'a')
io.close(fa)
frb = io.open("test01.txt", 'rb')
io.close(frb)
fwb = io.open("test01.txt", 'wb')
io.close(fwb)
fab = io.open("test01.txt", 'ab')
io.close(fab)
frr = io.open("test01.txt", 'r+')
io.close(frr)
fww = io.open("test01.txt", 'w+')
io.close(fww)
faa = io.open("test01.txt", 'a+')
io.close(faa)
frbr = io.open("test01.txt", 'rb+')
io.close(frbr)
fwbw = io.open("test01.txt", 'wb+')
io.close(fwbw)
faba = io.open("test01.txt", 'ab+')
io.close(faba)
fx = io.open("test01.txt", 'x')
io.close(fx)