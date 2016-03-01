#pragma version(1)
#pragma rs java_package_name(com.example.gabi.rssimple)

uchar4_attribute_((kernel)) bar(uin32_t x, uin32_t y){
    uchar4 ret = {(uchar) x, (uchar) y, (uchar) (x+y), (uchar)255};
    return ret;
}