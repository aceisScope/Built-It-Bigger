package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Andrés on 12/1/15.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public void testJokeDownload() {

        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.execute();

            String result = null;
            try {
                result = task.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertNotNull(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
