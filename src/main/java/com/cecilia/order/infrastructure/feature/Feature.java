package com.cecilia.order.infrastructure.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



    public enum Feature {
        GET_ALL_BOOKS(OrderAppRole.ADMIN),
        MAKE_ADMIN(OrderAppRole.CUSTOMER);



        private OrderAppRole[] roles;

        Feature(OrderAppRole... roles){
            this.roles = roles;
        }

        public List<OrderAppRole> getRoles(){
            return List.of(roles);
        }

        public static List<Feature> getFeaturesForRoles(List<OrderAppRole> rolesOfUser){

            List<Feature> listOfAllFeatures = List.of(Feature.values());
            List<Feature> allowedFeatures = new ArrayList<>();
            for(Feature feature : listOfAllFeatures){
                if(!Collections.disjoint(feature.getRoles(), rolesOfUser)){
                    allowedFeatures.add(feature);
                }
            }
            return allowedFeatures;
        }


    }


