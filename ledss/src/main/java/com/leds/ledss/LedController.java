package com.leds.ledss;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
@RequestMapping
public class LedController {
	
	private static GpioPinDigitalOutput pin;

	@GetMapping("yebo")
	public String heelo()
	{
		if(pin == null) {
			
			
			GpioController gpio = GpioFactory.getInstance();
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"MyLed",PinState.LOW);
		}
		
		
		pin.toggle();
		
		
		return "0";
	}
}
