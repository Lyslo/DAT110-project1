package no.hvl.dat110.tests.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat110.system.controller.Controller;
import no.hvl.dat110.system.display.DisplayDevice;
import no.hvl.dat110.system.sensor.SensorDevice;

class TestSystem {

    @Test
    void test() {

        System.out.println("System starting ...");

        Runnable display = () -> DisplayDevice.main(null);
        Runnable sensor = () -> SensorDevice.main(null);
        Runnable controller = () -> Controller.main(null);

        Thread displaythread = new Thread(display);
        Thread sensorthread = new Thread(sensor);
        Thread controllerthread = new Thread(controller);

        displaythread.start();
        sensorthread.start();

        // let the servers start first
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        controllerthread.start();

        try {

            displaythread.join();
            sensorthread.join();
            controllerthread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // we check only termination here
        assertTrue(true);

        System.out.println("System stopping ...");
    }

}