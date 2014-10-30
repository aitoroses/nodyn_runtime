package org.nodyn;

import io.nodyn.NoOpExitHandler;
import io.nodyn.Nodyn;
import io.nodyn.runtime.NodynConfig;
import io.nodyn.runtime.RuntimeFactory;

/**
 * Created by grayfox on 27/10/14.
 */

public class NodynRuntime {

    public static Nodyn instance = createNewInstance();

    public static Nodyn createNewInstance () {
        System.setProperty( "nodyn.binary", "./bin/node" );

        RuntimeFactory factory = RuntimeFactory.init( NodynRuntime.class.getClassLoader(), RuntimeFactory.RuntimeType.DYNJS );
        NodynConfig config = new NodynConfig( new String[] { "./scripts/index.js" } );
        Nodyn nodyn = factory.newRuntime(config);
        nodyn.setExitHandler( new NoOpExitHandler() );
        try {
            int exitCode = nodyn.run();
            if (exitCode != 0) {
                throw new Exception("Cannot Run Nodyn.");
            }
        } catch (Throwable t) {
            System.out.println( t.getMessage() );
        }

        return nodyn;
    }

    public static void main(String[] args) {}

}
