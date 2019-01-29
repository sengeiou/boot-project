package com.xzm.tyb.utils

/**
 * Created with IntelliJ IDEA.
 * User: Cuiyalei
 * Date: 2018/4/25
 * Time: 14:18
 * Pack: cn.qingker.sdk.tool.Byte
 * Description: the is Byte Description
 */
fun ByteArray.hex(start: Int = 0, end: Int = this.size): String? {
    val sb = StringBuilder()
    for (b in (start until end)) {
        val str = Integer.toHexString(this[b].unsigned())
        if(str.length==1){
            sb.append("0")
        }
        sb.append(str)
    }
    return sb.toString()
}

fun Byte.unsigned(): Int {
    return if (this > -1) this.toInt()
    else (this - Byte.MIN_VALUE) + Byte.MAX_VALUE + 1
}

infix fun Int.b(r: Int): ByteArray {
    return byteArrayOf(this.toByte(), r.toByte())
}

infix fun ByteArray.b(r: Int): ByteArray {
    return this + r.toByte()
}

fun ByteArray.toUnsigned(): String {
    val sb = StringBuilder("{")
    for (index in 0 until this.size) {
        sb.append(this[index].unsigned())
        if (index != this.size - 1) {
            sb.append(",")
        }
    }
    sb.append("}")
    return sb.toString()
}

fun ByteArray.ui(): Int {
    return (this[0].toInt() and 0xff or (this[1].toInt() shl 8 and 0xff00) or (this[2].toInt() shl 24).ushr(8)
            or (this[3].toInt() shl 24))
}
fun ByteArray.ul(): Long {
    return (0xffL and this[0].toLong() or (0xff00L and (this[1].toLong() shl 8)) or (0xff0000L and (this[2].toLong() shl 16)) or (0xff000000L and (this[3].toLong() shl 24))
            or (0xff00000000L and (this[4].toLong() shl 32)) or (0xff0000000000L and (this[5].toLong() shl 40)) or (0xff000000000000L and (this[6].toLong() shl 48)) or (-0x100000000000000L and (this[7].toLong() shl 56)))

}
fun String.hexStr():ByteArray{
    val bytes=ByteArray(this.length/2)
    for(index in 0 until  this.length/2){
        bytes[index]= Integer.valueOf(this.substring(index*2,(index+1)*2),16).toByte()
    }
    return bytes
}

fun ByteArray.indexOf(bytes:ByteArray,startIndex:Int=0):Int{
    if(bytes.isEmpty())return -1
    for(index in startIndex until this.size){
        if(index+bytes.size>this.size)return -1
        if(this[index]==bytes[0]){
            var isTrue=true
            for (i in 1 until bytes.size){
                if(this[index+i] !=bytes[i]){
                    isTrue=false
                    break
                }
            }
            if(isTrue){
                return index
            }
        }
    }
    return -1
}
fun ByteArray.replace(old:ByteArray,new:ByteArray,startIndex: Int=0,maxSize:Int=-1):ByteArray{
    var ths=this.copyOfRange(startIndex,this.size)
    var j=0
    while (true) {
        val start = ths.indexOf(old)
        if (start == -1) return this.copyOfRange(0,startIndex)+ths
        val left=ths.copyOf(start)
        ths=left+new+ths.copyOfRange(start+old.size,ths.size)
        j++
        if(maxSize!=-1&&j==maxSize)return this.copyOfRange(0,startIndex)+ths
    }
}
fun ByteArray.toStrUnsigned():String{
    val stringBuffer=StringBuffer()
    stringBuffer.append("{")
    for(index in 0 until this.size){
        stringBuffer.append(this[index].unsigned())
        if(index!=this.size-1) {
            stringBuffer.append(",")
        }
    }
    stringBuffer.append("}")
    return stringBuffer.toString()
}
fun byteUArrayOf(vararg bs:Int):ByteArray{
    val bytes=ByteArray(bs.size)
    for(index in 0 until bs.size){
        bytes[index]=bs[index].toByte()
    }
    return bytes
}
fun ByteArray.split(bytes: ByteArray):List<ByteArray>{
    var index: Int
    var last=0
    val list= mutableListOf<ByteArray>()
    do{
        index=this.indexOf(bytes,last)
        if(index==-1){
            list.add(this.copyOfRange(last,this.size))
            break
        }else{
            list.add(this.copyOfRange(last,index))
        }
        last=index+bytes.size
    }while (index!=-1)
    return list
}