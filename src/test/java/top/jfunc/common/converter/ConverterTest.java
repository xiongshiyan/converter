package top.jfunc.common.converter;

import org.junit.Assert;
import org.junit.Test;
import top.jfunc.json.JsonArray;
import top.jfunc.json.JsonObject;

/**
 * @author xiongshiyan at 2018/8/23 , contact me with email yanshixiong@126.com or phone 15208384257
 */
public class ConverterTest {
    @Test
    public void testJsonConverter(){
        String src = "{\"xx\":\"ss\",\"cc\":12}";
        JsonConverter converter = new DefaultJsonConverter();
        JsonObject jsonObject = converter.convertJsonObject(src);
        Assert.assertEquals("ss" , jsonObject.getString("xx"));
        Assert.assertTrue(12 == jsonObject.getInteger("cc"));


        String ss = "[\"xx\",12,34]";
        JsonArray jsonArray = converter.convertJsonArray(ss);
        Assert.assertEquals("xx" , jsonArray.getString(0));
        Assert.assertTrue(12 == jsonArray.getInteger(1));
        Assert.assertTrue(34 == jsonArray.getInteger(2));
    }
    @Test
    public void testBean(){
        String src = "{\"xx\":\"ss\",\"cc\":12}";
        JsonConverter converter = new DefaultJsonConverter();
        Bean bean = converter.convert(src, Bean.class);

        Assert.assertTrue("ss".equals(bean.getXx()));
        Assert.assertTrue(12 == bean.getCc());
    }

    private static final class Bean{
        private String xx;
        private int cc;

        public String getXx() {
            return xx;
        }

        public void setXx(String xx) {
            this.xx = xx;
        }

        public int getCc() {
            return cc;
        }

        public void setCc(int cc) {
            this.cc = cc;
        }
    }
}
