package com.noodles.encryptDecrypt.util;

/**
 * 功能描述：提供base64字符串与字节数组的编解码转换
 */
public class Base64{

    public static void main(String[] args) throws Exception{

        String base64Jdk7 = "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxr\n"
                + "dHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNs\n"
                + "amxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1h\n"
                + "YmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVy\n"
                + "dG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXll\n"
                + "bmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hn\n"
                + "YXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1\n"
                + "Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGps\n"
                + "a3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJj\n"
                + "bGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRt\n"
                + "YWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5l\n"
                + "cnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5\n"
                + "ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0dWNo\n"
                + "Z2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xqbGt0\n"
                + "dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFiY2xq\n"
                + "bGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0bWFi\n"
                + "Y2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVuZXJ0\n"
                + "bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdheWVu\n"
                + "ZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVjaGdh\n"
                + "eWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG1hYmNsamxrdHVj\n"
                + "aGdheWVuZXJ0bWFiY2xqbGt0dWNoZ2F5ZW5lcnRtYWJjbGpsa3R1Y2hnYXllbmVydG0=";

        System.out.println(base64Jdk7);



        //String base64 = "PCFET0NUWVBFIGh0bWwgUFVCTElDICItLy9XM0MvL0RURCBYSFRNTCAxLjAgVHJhbnNpdGlvbmFsLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL1RSL3hodG1sMS9EVEQveGh0bWwxLXRyYW5zaXRpb25hbC5kdGQiPjxodG1sIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hodG1sIj48aGVhZD48bWV0YSBjaGFyc2V0PSJVVEYtOCI+PHN0eWxlIHR5cGU9InRleHQvY3NzIj5AY2hhcnNldCAiVVRGLTgiOw0KaHRtbCwgYm9keSwgaDEsIGgyLCBoMywgaDQsIGg1LCBoNiwgcCwgZGwsIGR0LCBkZCwgdWwsIGxpLCBpbnB1dCB7bWFyZ2luOjA7cGFkZGluZzowO2ZvbnQtZmFtaWx5OidtaWNyb3NvZnQgeWFoZWknLGFyaWFsLGhlbHZldGljYTtjb2xvcjojNjY2O30NCnVsLCBsaSB7bGlzdC1zdHlsZTpub25lO30NCmF7dGV4dC1kZWNvcmF0aW9uOm5vbmU7b3V0bGluZTpub25lO30NCmlucHV0LGltZyxidXR0b257b3V0bGluZTpub25lO2JvcmRlcjpub25lO30NCip7DQotd2Via2l0LXRvdWNoLWNhbGxvdXQ6bm9uZTsNCi13ZWJraXQtdXNlci1zZWxlY3Q6bm9uZTsNCi1raHRtbC11c2VyLXNlbGVjdDpub25lOw0KLW1vei11c2VyLXNlbGVjdDpub25lOw0KLW1zLXVzZXItc2VsZWN0Om5vbmU7DQp1c2VyLXNlbGVjdDpub25lOw0KfQ0KLyrmnI3liqHljY/orq4qLw0KLm10MTB7bWFyZ2luLXRvcDo1cHg7fQ0KLm10MjB7bWFyZ2luLXRvcDoxMHB4O30NCi5tYjEwe21hcmdpbi1ib3R0b206NXB4O30NCi5tbDIwe21hcmdpbi1sZWZ0OjIwcHg7fQ0KLm1yMjB7bWFyZ2luLXJpZ2h0OjEwcHg7fQ0KLmdyYXl7Y29sb3I6IzY2Njt9DQouYiwuYiBwe2NvbG9yOiMwMDB9DQouZnMxNHtmb250LXNpemU6MTRweDt9DQouZnMxNntmb250LXNpemU6IDE2cHh9DQoudGJ7ZGlzcGxheTp0YWJsZTt9DQoudGN7ZGlzcGxheTp0YWJsZS1jZWxsO3BhZGRpbmctcmlnaHQ6OHB4O30NCi50cnt0ZXh0LWFsaWduOnJpZ2h0O30NCi5mbHtmbG9hdDogbGVmdDt9DQppbnB1dHt0ZXh0LWFsaWduOmNlbnRlcjt9DQouaW5wdXR7Ym9yZGVyLWJvdHRvbToxcHggc29saWQgI2FhYTtwYWRkaW5nOjAgNXB4O2NvbG9yOiM2NjY7d29yZC1icmVhazpicmVhay1hbGw7fQ0KLmxpbmV7Y29sb3I6IzAwMDt0ZXh0LWRlY29yYXRpb246dW5kZXJsaW5lO30NCi5oZWFkVG9we2JvcmRlci1ib3R0b206MXB4IHNvbGlkICNhYWE7cGFkZGluZzo1cHg7Zm9udC1zaXplOjEycHg7fQ0KLmhlYWRUaXRsZXt0ZXh0LWFsaWduOmNlbnRlcjtjb2xvcjojMDAwO2ZvbnQtc2l6ZToxOHB4O21hcmdpbjoxMHB4IDEwcHg7fQ0KLmhlYWRUaXRsZTJ7dGV4dC1hbGlnbjpjZW50ZXI7Y29sb3I6IzAwMDtmb250LXNpemU6MTZweDttYXJnaW46MHB4IGF1dG8gMTBweCBhdXRvO30NCi50aXR7Zm9udC1zaXplOjE2cHg7Y29sb3I6IzAwMDt9DQoudGl0IGZvbnR7bWFyZ2luLXJpZ2h0OjEwcHg7fQ0KLnNlcnZlLC5jb21tZW5kLC5yZXBvcnQsLmlvdSwuYnl7d2lkdGg6OTQlO21hcmdpbjowIGF1dG87bGluZS1oZWlnaHQ6MS42O2ZvbnQtc2l6ZToxNHB4O3BhZGRpbmctYm90dG9tOjIwcHg7fQ0KLnNlcnZlIC50aXB7Zm9udC1zaXplOjE2cHg7Y29sb3I6IzAwMDttYXJnaW4tYm90dG9tOjEwcHg7fQ0KLnNlcnZlIHVse3BhZGRpbmctbGVmdDoxMnB4O30NCi5zZXJ2ZSB1bCBsaXttYXJnaW4tdG9wOjEwcHg7fQ0KLnNlcnZlIHVsIGxpIHB7cGFkZGluZy1sZWZ0OjE5cHg7fQ0KLnNlcnZlIHVsIGxpIHAgZm9udHttYXJnaW4tcmlnaHQ6OHB4O30NCi5zZXJ2ZSAucDF7cGFkZGluZy1sZWZ0OjEycHg7fQ0KLnNlcnZlIC5wMSwuc2VydmUgYXtmb250LXNpemU6MTRweDtjb2xvcjojNjY2O30NCi5zZXJ2ZSAubGkyIC50aXAye3BhZGRpbmctbGVmdDoxOXB4O30NCi5zZXJ2ZSAubGkyIC50aXAyIGZvbnQsLnNlcnZlIC5saTMgLnRpcDIgZm9udHttYXJnaW4tcmlnaHQ6OHB4O30NCi5zZXJ2ZSAubGkyIHB7cGFkZGluZy1sZWZ0OjQ3cHg7fQ0KLnNlcnZlIC5saTIgLnAye3BhZGRpbmctbGVmdDo2NXB4O30NCi5zZXJ2ZSAubGkzIC50aXAye3BhZGRpbmctbGVmdDogMjZweDt9DQouc2VydmUgLmxpMyBwe3BhZGRpbmctbGVmdDo2MXB4O30NCi5zZXJ2ZSAubGkzIC5wMntwYWRkaW5nLWxlZnQ6ODhweDt9DQouc2VydmUgdWwgLmxpNCBwe3BhZGRpbmctbGVmdDoyOHB4O30NCi8q5a6i5oi35o6o6I2Q5Y2P6K6uKi8NCi5jb21tZW5kIC50aXAgcHtjb2xvcjojMDAwO30NCi5jb21tZW5kIC50aXAgcCBmb250e21hcmdpbi1yaWdodDo4cHg7fQ0KLmNvbW1lbmQgLnRpcCAucDJ7Y29sb3I6IzY2Njt9DQouY29tbWVuZCAubGlzdCBsaXttYXJnaW4tdG9wOjAuMzEyNXJlbTt9DQouY29tbWVuZCAubGlzdCBsaSBwIGZvbnR7bWFyZ2luLXJpZ2h0OjhweDt9DQouY29tbWVuZCAubGlzdCBsaSAucDJ7cGFkZGluZy1sZWZ0OjE4cHg7fQ0KLmNvbW1lbmQgLmxpc3QgbGkgLnAze3BhZGRpbmctbGVmdDozOHB4O30NCnRhYmxle2JvcmRlci1jb2xsYXBzZTpjb2xsYXBzZTt9DQouY29tbWVuZCB0YWJsZSB0aHtiYWNrZ3JvdW5kOiNlZWU7fQ0KLmNvbW1lbmQgdGFibGUgdGgsLmNvbW1lbmQgdGFibGUgdGR7dGV4dC1hbGlnbjpjZW50ZXI7fQ0KLyrkv6HnlKjmiqXlkYrmn6Xor6IqLw0KLnJlcG9ydHt3aWR0aDo5NiU7fQ0KLnJlcG9ydCB0YWJsZXt3aWR0aDoxMDAlO21hcmdpbjowIGF1dG87dGV4dC1hbGlnbjogY2VudGVyO2JvcmRlci1jb2xsYXBzZTpjb2xsYXBzZTt9DQoucmVwb3J0IHRhYmxlIGlucHV0W3R5cGU9ImNoZWNrYm94Il17bWFyZ2luLXRvcDotMnB4O3ZlcnRpY2FsLWFsaWduOiBtaWRkbGU7bWFyZ2luLWxlZnQ6MC4xNTYyNXJlbTt9DQoucmVwb3J0IHRhYmxlIGlucHV0W3R5cGU9J3RleHQnXS5sYXN0e2JvcmRlci1ib3R0b206MXB4IHNvbGlkICNhYWE7d2lkdGg6NTAlO30NCi5yZXBvcnQgLmxpc3QgcHtjb2xvcjojMDAwO30NCi5yZXBvcnQgLmxpc3QgcCBmb250e21hcmdpbi1yaWdodDo4cHg7fQ0KLnJlcG9ydCAuc2lnbiBwe2NvbG9yOiMwMDA7fQ0KLnJlcG9ydCAuc2lnbiAucDIgaW5wdXR7d2lkdGg6NTBweDtib3JkZXItYm90dG9tOjFweCBzb2xpZCAjYWFhO30NCi5yZXBvcnQgLklERXtoZWlnaHQ6NDBweDt9DQoucmVwb3J0IC5JREUgc3Bhbntib3JkZXI6IDFweCBzb2xpZCAjYWFhO21hcmdpbjowIDFweDtwYWRkaW5nOjNweCAxcHg7fQ0KLyrotLfmrL7lkIjlkIwqLw0KLmFncmVlbWVudCAubGlzdCBpbnB1dHtib3JkZXItYm90dG9tOjFweCBzb2xpZCAjYWFhO30NCi5hZ3JlZW1lbnQgLmxpc3QgbGkgLnAze3BhZGRpbmctbGVmdDo0OHB4O30NCi8q5aeU5omY5YiS5qy+Ki8NCi5ieSBpbnB1dHtib3JkZXItYm90dG9tOjFweCBzb2xpZCAjYWFhO30NCi5ieSAubGlzdCBwe3BhZGRpbmctbGVmdDoyOHB4O30NCi5ieSAubGlzdCBwIGZvbnR7bWFyZ2luLXJpZ2h0OjhweDt9DQovKiDpo47pmanmj5DnpLogKi8NCi5yaXNrX3RpcCAubGlzdCBsaSAucDJ7cGFkZGluZy1sZWZ0OiAzMHB4O30NCi8qIOWinuWKoOWFqOWxgGNzcyAqLw0KLm1heFd7d2lkdGg6IDkwJX0NCnB7cGFnZS1icmVhay1pbnNpZGU6YXZvaWQ7fQ0KLmRlZHVjdGVkTGlzdCAudGl0bGV7dGV4dC1hbGlnbjpjZW50ZXI7fQ0KLmRlZHVjdGVkTGlzdCBsaXtvdmVyZmxvdzogaGlkZGVuO30NCi5kZWR1Y3RlZExpc3QgbGk+ZGl2e3dpZHRoOjQwJTtmbG9hdDpyaWdodDtwYWRkaW5nOjVweCAwIDVweCAzJTtib3gtc2l6aW5nOmJvcmRlci1ib3g7fQ0KLmRlZHVjdGVkTGlzdCBsaT5kaXYuZDF7d2lkdGg6NjAlO2Zsb2F0OmxlZnQ7Ym9yZGVyLXJpZ2h0OjFweCBzb2xpZCAjMzMzO3BhZGRpbmc6NXB4IDMlIDVweCAwO30NCi5kZWR1Y3RlZExpc3QgLnRpdGxlPmRpdntwYWRkaW5nOjVweCAwO30NCi5kZWR1Y3RlZExpc3QgbGkgLnRvdGFse3RleHQtYWxpZ246IHJpZ2h0O308L3N0eWxlPjx0aXRsZT7mnInlhbPkvb/nlKjpgJrogZTmlK/ku5jmlLbpk7blrp3lubPlj7Dov5vooYzlgJ/otLfotYTph5HliJLku5jmtLvliqjnmoTmhI/lkJHljY/orq48L3RpdGxlPjwvaGVhZD48Ym9keT4gCiA8ZGl2IGNsYXNzPSJoZWFkVGl0bGUiPgogIOacieWFs+S9v+eUqOmAmuiBlOaUr+S7mOaUtumTtuWuneW5s+WPsOi/m+ihjOWAn+i0t+i1hOmHkeWIkuS7mOa0u+WKqOeahOaEj+WQkeWNj+iurgogPC9kaXY+IAogPGJyPiAKIDxkaXYgY2xhc3M9ImNvbW1lbmQgYWdyZWVtZW50Ij4gCiAgPGRpdiBjbGFzcz0idGlwIj4gCiAgIDxwIGNsYXNzPSJwMiI+55Sy5pa577yaPHNwYW4gY2xhc3M9ImlucHV0Ij7ogpboi5foi5c8L3NwYW4+PC9wPiAKICAgPHAgY2xhc3M9InAyIj7kuZnmlrnvvJo8c3BhbiBjbGFzcz0iaW5wdXQiPua3seWcs+S6muiBlOi0ouWwj+minei0t+asvuaciemZkOWFrOWPuDwvc3Bhbj48L3A+IAogICA8cCBjbGFzcz0icDIiPuS4meaWue+8mjxzcGFuIGNsYXNzPSJpbnB1dCI+6YCa6IGU5pSv5LuY572R57uc5pyN5Yqh6IKh5Lu95pyJ6ZmQ5YWs5Y+4PC9zcGFuPjwvcD4gCiAgIDxwIGNsYXNzPSJtdDIwIHAyIj7pibTkuo7vvJo8L3A+IAogICA8cCBjbGFzcz0icDIgdGIiPjxmb250IGNsYXNzPSJ0YyI+MeOAgTwvZm9udD48c3Bhbj7nlLLmlrnpgJrov4fkuJnmlrnlvIDlj5HnmoTigJzmlLbpk7blrp3igJ3lubPlj7DvvIjnm67liY3lvIDpgJrmuKDpgZPkuLrlvq7kv6HlhazkvJflj7fvvIzkuIvnroDnp7DigJzmlLbpk7blrp3igJ3vvInlkJHkuZnmlrnnlLPor7fotLfmrL7vvIzkuZnmlrnlkIzmhI/lkJHnlLLmlrnmj5DkvpvotLfmrL7mnI3liqHvvIznlLLmlrnoh6rmhL/pgInmi6nmjqXlj5fkuZnmlrnnmoTliY3ov7DotLfmrL7mnI3liqHjgII8L3NwYW4+PC9wPiAKICAgPHAgY2xhc3M9InAyIHRiIj48Zm9udCBjbGFzcz0idGMiPjLjgIE8L2ZvbnQ+5LiZ5pa56YCa6L+H5YW25byA5Y+R6K6+56uL5a6e6ZmF6L+Q6JCl55qE4oCc5pS26ZO25a6d4oCd5Y2P5Yqp55Sy5LmZ5Y+M5pa55bCx5pys5qyh6LS35qy+5LqL5a6c6L+b6KGM6LWE6YeR5YiS5LuY44CCPC9wPiAKICAgPHAgY2xhc3M9InAyIG10MjAiPueOsOWwseeUsuOAgeS5meOAgeS4meS4ieaWueWwseaUtumTtuWuneeahOS9v+eUqOS7peWPiuS9v+eUqOi/h+eoi+S4reWQhOaWueadg+WIqeS5ieWKoeS9nOWHuuWmguS4i+e6puWumu+8iOKAnOacrOWNj+iuruKAne+8ie+8mjwvcD4gCiAgPC9kaXY+IAogIDx1bCBjbGFzcz0ibGlzdCBtdDIwIj4gCiAgIDxsaT4gPHAgY2xhc3M9InRiIj48Zm9udCBjbGFzcz0idGMiPjHjgIE8L2ZvbnQ+PHNwYW4+55Sy5pa56YCa6L+H4oCc5pS26ZO25a6d4oCd5ZCR5LmZ5pa555Sz6K+36LS35qy+77yM6aG75ruh6Laz55Sy5pa55Lul6Ieq54S25Lq65ZCN5LmJ5Zyo5LiZ5pa55rOo5YaM5ZWG5oi377yM5oiW55Sy5pa55Lul5Liq5L2T5bel5ZWG5oi357uP6JCl5Lq65ZCN5LmJ5Zyo5LiZ5pa55rOo5YaM5ZWG5oi344CC5Lul5LiK5ZWG5oi35ZCO6KKr56ew5Li655Sy5pa55o6n5Yi255qE5ZWG5oi344CCPC9zcGFuPjwvcD4gPHAgY2xhc3M9InRiIG10MTAiPjxmb250IGNsYXNzPSJ0YyI+MuOAgTwvZm9udD48c3Bhbj7nlLLmlrnmjojmnYPlubbmjIflrprlhbbmjqfliLbnmoTllYbmiLflnKjigJzmlLbpk7blrp3igJ3nmoTms6jlhoznmoTomZrmi5/otKbmiLfvvIjigJznlLLmlrnllYbmiLfmlLbpk7blrp3otKbmiLfigJ3vvInkuLrmlLblj5bkuZnmlrnlj5HmlL7otLfmrL7nmoTotKbmiLfvvIznlLLmlrnlj6/pgJrov4fotKbmiLfnmoToh6rkuLvmj5DnjrDmiJboh6rliqjnu5Pnrpflip/og73vvIzlsIbkuZnmlrnlj5HmlL7otLfmrL7otYTph5HovazlhaXnlLLmlrnpk7booYzotKbmiLfjgILor6Xpk7booYzotKbmiLfkuLrnlLLmlrnllYbmiLfmlLbpk7blrp3otKbmiLfnmoTotYTph5Hnu5PnrpfotKbmiLfvvIzkuJTor6Xnu5PnrpfotKbmiLflnKjnlLLmlrnnlLPor7fmnKzotLfmrL7kuJrliqHkuYvlkI7oh7PnlLLmlrnpgJrov4fmlLbpk7blrp3lubPlj7DnlLPor7fnmoTmiYDmnInotLfmrL7muIXlgb/kuYvliY3kuI3lhYHorrjlj5HnlJ/lj5jmm7TjgILnlLLmlrnmjqfliLbnmoTllYbmiLflnKjmlLbpk7blrp3lubPlj7DotKbmiLfnmoTmk43kvZzop4TliJnvvIznlLHnlLLjgIHkuJnlj4zmlrnlj6bnq4vlkIjlkIznuqblrprjgII8L3NwYW4+PC9wPiA8cCBjbGFzcz0idGIgbXQxMCI+PGZvbnQgY2xhc3M9InRjIj4z44CBPC9mb250PjxzcGFuPuS5meaWueS9v+eUqOKAnOaUtumTtuWuneKAneS9nOS4uuWQkeeUsuaWueWPkeaUvui0t+asvueahOWUr+S4gOa4oOmBk+OAguS4uui+vuWIsOi/meS4gOebrueahO+8jOS5meaWuemhu+WcqOKAnOaUtumTtuWuneKAneW8gOmAmui0puaIt++8iOKAnOS5meaWueaUtumTtuWunei0puaIt+KAne+8ieOAguS5meaWueWcqOKAnOaUtumTtuWuneKAneeahOaTjeS9nOinhOWIme+8jOeUseS5meOAgeS4meWPjOaWueWPpueri+WQiOWQjOe6puWumuOAgjwvc3Bhbj48L3A+IDxwIGNsYXNzPSJ0YiBtdDEwIj48Zm9udCBjbGFzcz0idGMiPjTjgIE8L2ZvbnQ+PHNwYW4+5Zyo5LmZ5pa55ZCM5oSP55Sy5pa56LS35qy+55Sz6K+377yM5bm257uZ5Ye65o6I5L+h6aKd5bqm5ZCO77yM55Sy5pa55Y+v6YCa6L+H55Sy5pa55pS26ZO25a6d6LSm5oi35Y+R6LW35pSv55So5oyH5Luk77yM5pSv55So6YeR6aKd5LiN5b6X5aSn5LqO5o6I5L+h6aKd5bqm44CC4oCc5pS26ZO25a6d4oCd5bCG5qC55o2u5oyH5Luk5oqK6LWE6YeR5LuO5LmZ5pa55pS26ZO25a6d6LSm5oi36L2s5YWl55Sy5pa55ZWG5oi35pS26ZO25a6d6LSm5oi344CC5LmZ5pa55a6e6ZmF5pS+5qy+5pe26Ze05Lul5LiZ5pa557O757uf6K6w5b2V55qE6LWE6YeR5YiS5LuY5pe26Ze05Li65YeG44CCPC9zcGFuPjwvcD4gPHAgY2xhc3M9InRiIG10MTAiPjxmb250IGNsYXNzPSJ0YyI+NeOAgTwvZm9udD48c3Bhbj7kuZnmlrnpobvnoa7kv53kuZnmlrnmlLbpk7blrp3otKbmiLfkvZnpop3mu6HotrPlj5HmlL7otLfmrL7pnIDopoHjgILlvZPkuZnmlrnmlLbpk7blrp3otKbmiLfkvZnpop3kuI3otrPml7bmlLbpk7blrp3ns7vnu5/lupTlnKjkvZnpop3kvY7kuo5Y5LiH5YWD5oiW5LiN6Laz5Lul5Y+R5pS+6LS35qy+5pe25ZCR5LmZ5pa56L+b6KGM5o+Q56S677yM5LmZ5pa55pS25oKJ5o+Q56S65ZCO5bqU5Y+K5pe25ZCR5LmZ5pa55pS26ZO25a6d6LSm5oi35Lit6L+b6KGM6L2s5qy+5YWF5YC877yM5aaC5LmZ5pa55pS25oKJ5o+Q56S65ZCO5pyq6IO95Y+K5pe25YWF5YC85a+86Ie04oCc5pS26ZO25a6d4oCd5peg5rOV5oyJ5LmZ5pa55oyH5Luk5a+56LS35qy+6L+b6KGM5YiS5LuY55qE77yM55Sx5q2k5omA5Lqn55Sf55qE5o2f5aSx55Sx5LmZ5pa55om/5ouF44CCPC9zcGFuPjwvcD4gPHAgY2xhc3M9InRiIG10MTAiPjxmb250IGNsYXNzPSJ0YyI+NuOAgTwvZm9udD48c3Bhbj7nlLLkuJnmlrnkuYvpl7TjgIHkuZnkuJnmlrnkuYvpl7TlsIblsLHmlLbpk7blrp3kuYvmk43kvZzkvb/nlKjku6Xlj4rlkITmlrnmnYPliKnkuYnliqHlj6booYznrb7orqLlhbfkvZPlsaXooYzkuYvkuabpnaLljY/orq7vvIzkuJnmlrnmib/or7rlubbkv53pmpzlhbbljY/orq7lhoXlrrnlnYfkuI3kvJrov53lj43mnKzljY/orq7nuqblrprkuYvlhoXlrrnmiJbkuqfnlJ/lhrLnqoHvvIzkuqbkuI3kvJrlr7nkuo7nlLLkuZnmlrnkvb/nlKjmlLbpk7blrp3ov5vooYzlgJ/otLfmrL7pobnliJLmi6jpgKDmiJDku7vkvZXlhbbku5bpmpznoo3miJblr7nkuo7nlLLkuZnmlrnkvb/nlKjmlLbpk7blrp3ov5vooYzlgJ/otLfmrL7pobnliJLmi6jkuqfnlJ/pop3lpJbnmoTotLnnlKjjgII8L3NwYW4+PC9wPiA8cCBjbGFzcz0idGIgbXQxMCI+PGZvbnQgY2xhc3M9InRjIj4344CBPC9mb250PjxzcGFuPuWmguWwseacrOWNj+iuruS6p+eUn+S7u+S9lee6oOe6t+S4lOaXoOazleWNj+WVhuS4gOiHtOeahO+8jOW6lOWQkeiiq+WRiuaJgOWcqOWcsOazlemZouaPkOi1t+ivieiuvOOAgjwvc3Bhbj48L3A+IDwvbGk+IAogIDwvdWw+IAogIDxicj4gCiAgPGRpdj4gCiAgIDxwIGNsYXNzPSJtYjEwIj7nlLLmlrnvvJo8c3BhbiBjbGFzcz0iaW5wdXQiPuiCluiLl+iLlzwvc3Bhbj48L3A+IAogICA8cCBjbGFzcz0icDIiPuaOiOadg+S7o+ihqOS6uu+8mjwvcD4gCiAgIDxwIGNsYXNzPSJwMiBtdDEwIj7nrb7lrZfml6XmnJ/vvJo8c3BhbiBjbGFzcz0iaW5wdXQiPjIwMTk8L3NwYW4+5bm0PHNwYW4gY2xhc3M9ImlucHV0Ij4yPC9zcGFuPuaciDxzcGFuIGNsYXNzPSJpbnB1dCI+MjE8L3NwYW4+5pelPC9wPiAKICAgPGJyPiAKICAgPHAgY2xhc3M9Im1iMTAiPuS5meaWue+8mua3seWcs+S6muiBlOi0ouWwj+minei0t+asvuaciemZkOWFrOWPuDwvcD4gCiAgIDxwIGNsYXNzPSJwMiI+5o6I5p2D5Luj6KGo5Lq677yaPC9wPiAKICAgPHAgY2xhc3M9InAyIG10MTAiPuetvuWtl+aXpeacn++8mjxzcGFuIGNsYXNzPSJpbnB1dCI+MjAxOTwvc3Bhbj7lubQ8c3BhbiBjbGFzcz0iaW5wdXQiPjI8L3NwYW4+5pyIPHNwYW4gY2xhc3M9ImlucHV0Ij4yMTwvc3Bhbj7ml6U8L3A+IAogICA8YnI+IAogICA8cCBjbGFzcz0ibWIxMCI+5LiZ5pa577ya6YCa6IGU5pSv5LuY572R57uc5pyN5Yqh6IKh5Lu95pyJ6ZmQ5YWs5Y+4PC9wPiAKICAgPHAgY2xhc3M9InAyIj7mjojmnYPku6PooajkurrvvJo8L3A+IAogICA8cCBjbGFzcz0icDIgbXQxMCI+562+5a2X5pel5pyf77yaPHNwYW4gY2xhc3M9ImlucHV0Ij4yMDE5PC9zcGFuPuW5tDxzcGFuIGNsYXNzPSJpbnB1dCI+Mjwvc3Bhbj7mnIg8c3BhbiBjbGFzcz0iaW5wdXQiPjIxPC9zcGFuPuaXpTwvcD4gCiAgPC9kaXY+IAogPC9kaXY+IAo8L2JvZHk+PC9odG1sPg==";

        long start = System.currentTimeMillis();

        /**算法 2毫秒*/
        String t = base64Jdk7.replaceAll("\n", "");
        System.out.println(new String(base64ToByteArray(t)));

        /**jdk8 2毫秒*/
        //System.out.println(new String(java.util.Base64.getDecoder().decode(t), "utf-8"));

        System.out.println(System.currentTimeMillis() - start);


    }

    /**
     * Translates the specified byte array into a Base64 string as per
     * Preferences.put(byte[]).
     */
    public static String byteArrayToBase64(byte[] a){
        return byteArrayToBase64(a, false);
       
    }

    /**
     * Translates the specified byte array into an "aternate representation"
     * Base64 string. This non-standard variant uses an alphabet that does not
     * contain the uppercase alphabetic characters, which makes it suitable for
     * use in situations where case-folding occurs.
     */
    public static String byteArrayToAltBase64(byte[] a){
        return byteArrayToBase64(a, true);
    }

    private static String byteArrayToBase64(byte[] a, boolean alternate){
        int aLen = a.length;
        int numFullGroups = aLen / 3;
        int numBytesInPartialGroup = aLen - 3 * numFullGroups;
        int resultLen = 4 * ((aLen + 2) / 3);
        StringBuffer result = new StringBuffer(resultLen);
        char[] intToAlpha = (alternate ? intToAltBase64 : intToBase64);

        // Translate all full groups from byte array elements to Base64
        int inCursor = 0;
        for(int i = 0; i < numFullGroups; i++){
            int byte0 = a[inCursor++] & 0xff;
            int byte1 = a[inCursor++] & 0xff;
            int byte2 = a[inCursor++] & 0xff;
            result.append(intToAlpha[byte0 >> 2]);
            result.append(intToAlpha[(byte0 << 4) & 0x3f | (byte1 >> 4)]);
            result.append(intToAlpha[(byte1 << 2) & 0x3f | (byte2 >> 6)]);
            result.append(intToAlpha[byte2 & 0x3f]);
        }

        // Translate partial group if present
        if(numBytesInPartialGroup != 0){
            int byte0 = a[inCursor++] & 0xff;
            result.append(intToAlpha[byte0 >> 2]);
            if(numBytesInPartialGroup == 1){
                result.append(intToAlpha[(byte0 << 4) & 0x3f]);
                result.append("==");
            }else{
                // assert numBytesInPartialGroup == 2;
                int byte1 = a[inCursor++] & 0xff;
                result.append(intToAlpha[(byte0 << 4) & 0x3f | (byte1 >> 4)]);
                result.append(intToAlpha[(byte1 << 2) & 0x3f]);
                result.append('=');
            }
        }
        // assert inCursor == a.length;
        // assert result.length() == resultLen;
        return result.toString();
    }

    /**
     * This array is a lookup table that translates 6-bit positive integer index
     * values into their "Base64 Alphabet" equivalents as specified in Table 1
     * of RFC 2045.
     */
    private static final char intToBase64[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /**
     * This array is a lookup table that translates 6-bit positive integer index
     * values into their "Alternate Base64 Alphabet" equivalents. This is NOT
     * the real Base64 Alphabet as per in Table 1 of RFC 2045. This alternate
     * alphabet does not use the capital letters. It is designed for use in
     * environments where "case folding" occurs.
     */
    private static final char intToAltBase64[] = {'!', '"', '#', '$', '%', '&', '\'', '(', ')', ',', '-',
            '.', ':', ';', '<', '>', '@', '[', ']', '^', '`', '_', '{', '|', '}', '~', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '?'};

    /**
     * Translates the specified Base64 string (as per Preferences.get(byte[]))
     * into a byte array.
     * 
     * @throw IllegalArgumentException if <tt>s</tt> is not a valid Base64
     *        string.
     */
    public static byte[] base64ToByteArray(String s){
        return base64ToByteArray(s, false);
    }

    /**
     * Translates the specified "aternate representation" Base64 string into a
     * byte array.
     * 
     * @throw IllegalArgumentException or ArrayOutOfBoundsException if
     *        <tt>s</tt> is not a valid alternate representation Base64 string.
     */
    public static byte[] altBase64ToByteArray(String s){
        return base64ToByteArray(s, true);
    }

    private static byte[] base64ToByteArray(String s, boolean alternate){
        byte[] alphaToInt = (alternate ? altBase64ToInt : base64ToInt);
        int sLen = s.length();
        int numGroups = sLen / 4;
        if(4 * numGroups != sLen)
            throw new IllegalArgumentException("String length must be a multiple of four.");
        int missingBytesInLastGroup = 0;
        int numFullGroups = numGroups;
        if(sLen != 0){
            if(s.charAt(sLen - 1) == '='){
                missingBytesInLastGroup++;
                numFullGroups--;
            }
            if(s.charAt(sLen - 2) == '=')
                missingBytesInLastGroup++;
        }
        byte[] result = new byte[3 * numGroups - missingBytesInLastGroup];
        char[] a = s.toCharArray();
        // Translate all full groups from base64 to byte array elements
        int inCursor = 0, outCursor = 0;
        for(int i = 0; i < numFullGroups; i++){
            int ch0 = base64toInt(a[inCursor++], alphaToInt);
            int ch1 = base64toInt(a[inCursor++], alphaToInt);
            int ch2 = base64toInt(a[inCursor++], alphaToInt);
            int ch3 = base64toInt(a[inCursor++], alphaToInt);
            result[outCursor++] = (byte) ((ch0 << 2) | (ch1 >> 4));
            result[outCursor++] = (byte) ((ch1 << 4) | (ch2 >> 2));
            result[outCursor++] = (byte) ((ch2 << 6) | ch3);
        }

        // Translate partial group, if present
        if(missingBytesInLastGroup != 0){
            int ch0 = base64toInt(a[inCursor++], alphaToInt);
            int ch1 = base64toInt(a[inCursor++], alphaToInt);
            result[outCursor++] = (byte) ((ch0 << 2) | (ch1 >> 4));

            if(missingBytesInLastGroup == 1){
                int ch2 = base64toInt(a[inCursor++], alphaToInt);
                result[outCursor++] = (byte) ((ch1 << 4) | (ch2 >> 2));
            }
        }
        // assert inCursor == s.length()-missingBytesInLastGroup;
        // assert outCursor == result.length;
        return result;
    }

    /**
     * Translates the specified character, which is assumed to be in the
     * "Base 64 Alphabet" into its equivalent 6-bit positive integer.
     * 
     * @throw IllegalArgumentException or ArrayOutOfBoundsException if c is not
     *        in the Base64 Alphabet.
     */
    private static int base64toInt(char c, byte[] alphaToInt){
        int result = alphaToInt[c];
        if(result < 0)
            throw new IllegalArgumentException("Illegal character " + c);
        return result;
    }

    /**
     * This array is a lookup table that translates unicode characters drawn
     * from the "Base64 Alphabet" (as specified in Table 1 of RFC 2045) into
     * their 6-bit positive integer equivalents. Characters that are not in the
     * Base64 alphabet but fall within the bounds of the array are translated to
     * -1.
     */
    private static final byte base64ToInt[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1,
            -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
            43, 44, 45, 46, 47, 48, 49, 50, 51};

    /**
     * This array is the analogue of base64ToInt, but for the nonstandard
     * variant that avoids the use of uppercase alphabetic characters.
     */
    private static final byte altBase64ToInt[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7,
            8, -1, 62, 9, 10, 11, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 12, 13, 14, -1, 15, 63, 16, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 17, -1, 18, 19, 21, 20, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
            43, 44, 45, 46, 47, 48, 49, 50, 51, 22, 23, 24, 25};
}
