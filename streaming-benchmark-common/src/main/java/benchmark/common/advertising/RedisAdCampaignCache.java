/**
 * Copyright 2015, Yahoo Inc.
 * Licensed under the terms of the Apache License 2.0. Please see LICENSE file in the project root for terms.
 */
package benchmark.common.advertising;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class RedisAdCampaignCache {
    private Jedis jedis;
    private HashMap<String, String> ad_to_campaign;

    public RedisAdCampaignCache(String redisServerHostname) {

        System.out.println("    +--------------------------------------------------+");
        System.out.println("    |   RedisAdCampaignCache                           |");
        System.out.println("    |       constructor                                |");
        System.out.println("    +--------------------------------------------------+");



        jedis = new Jedis(redisServerHostname);
    }

    public void prepare() {
        
        System.out.println("    +--------------------------------------------------+");
        System.out.println("    |   RedisAdCampaignCache                           |");
        System.out.println("    |       prepare                                    |");
        System.out.println("    +--------------------------------------------------+");

        ad_to_campaign = new HashMap<String, String>();
    }


    public String execute(String ad_id) {
        //System.out.println("");
        //System.out.println("INSIDE RedisAdCampaignCache BEFORE CALLING REDIS");
        //System.out.println("ad_id : " + ad_id);
        //TODO

        System.out.println("    +--------------------------------------------------+");
        System.out.println("    |   RedisAdCampaignCache                           |");
        System.out.println("    |       ad_id       : " + ad_id);

        String campaign_id = ad_to_campaign.get(ad_id);

        System.out.println("    |       campaign_id : " + campaign_id + " [From cache (HashMap)]");

        if(campaign_id == null) {

//HERE
            campaign_id = jedis.get(ad_id);

        System.out.println("    |       campaign_id : " + campaign_id + " [From jedis]");

            if(campaign_id == null) {
                return null;
            }
            else {
                ad_to_campaign.put(ad_id, campaign_id);
            }
        }

        System.out.println("    |       campaign_id : " + campaign_id);
        System.out.println("    +--------------------------------------------------+");


        return campaign_id;
    }
}
