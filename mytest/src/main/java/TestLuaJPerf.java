import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;
 
public class TestLuaJPerf {
 
    public static void main(String[] args) {
 
        int iterNum = 10000;
 
        // *) java 模式运行
        long beg = System.currentTimeMillis();
        for ( int j = 0; j < iterNum; j++ ) {
            int a = 0;
            for ( int i = 0; i < 10000; i++ ) {
                a = a + i;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Java consume: %dms", end - beg));
 
        // *) Lua脚本解析执行
        String luaStr = "a = 0; for i = 0, 10000, 1 do a = a + i; end";
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        beg = System.currentTimeMillis();
        for ( int i = 0; i < iterNum; i++ ) {
            chunk.call();
        }
        end = System.currentTimeMillis();
        System.out.println(String.format("Lua consume: %dms", end - beg));
 
    }
 
}