package org.nodyn;

import io.nodyn.NoOpExitHandler;
import io.nodyn.Nodyn;
import io.nodyn.runtime.NodynConfig;
import io.nodyn.runtime.RuntimeFactory;

/**
 * Created by grayfox on 27/10/14.
 */

public class Main {

    public static Nodyn nodyn;

    public static void init () {
        System.setProperty( "nodyn.binary", "./bin/node" );

        RuntimeFactory factory = RuntimeFactory.init( Main.class.getClassLoader(), RuntimeFactory.RuntimeType.DYNJS );
        NodynConfig config = new NodynConfig( new String[] { "./scripts/index.js" } );
        nodyn = factory.newRuntime(config);
        nodyn.setExitHandler( new NoOpExitHandler() );
        try {
            int exitCode = nodyn.run();
            if (exitCode != 0) {
                throw new Exception("Cannot Run Nodyn.");
            }
        } catch (Throwable t) {
            System.out.println( t.getMessage() );
        }
    }

    public static void main(String[] args) {
        Main.init();
    }

}
