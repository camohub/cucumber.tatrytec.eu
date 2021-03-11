
package services;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class ConfigSingletonService
{

    private static Config config;


    /**
     * Returns config singleton
     * @return
     */
    public static Config conf()
    {
        if( config == null ) config = ConfigFactory.load();

        return config;
    }

}
