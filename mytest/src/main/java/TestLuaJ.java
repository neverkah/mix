import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;
 
public class TestLuaJ {
 
 
    public static void main(String[] args) {
 
        String luaStr = "print 'hello,world!'";
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        chunk.call();
 
    }
 
}