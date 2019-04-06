
package com.gary.interview.java8.stream;


import java.util.List;
import java.util.stream.Collectors;

import static com.gary.interview.java8.stream.PersonConstants.GENDER_MALE;

public class StreamService {
    private List<PersonModel> personModelList = MockPerson.getDate();


    /**
     * Filter
     *
     */

    // only left male
    public List<PersonModel> filterOutFemaleWithStream(){
        List<PersonModel> resultList = personModelList.stream().filter(personModel -> personModel.getGender().equalsIgnoreCase(GENDER_MALE)).collect(Collectors.toList());
        return resultList;
    }

    // only left male
    public List<PersonModel> filterOutFemaleWithoutStream(){
        List<PersonModel> resultList = null;
        for(PersonModel personModel : personModelList){
            if(personModel.getGender().equalsIgnoreCase(GENDER_MALE)){
                resultList.add(personModel);
            }
        }
        return resultList;
    }


}
