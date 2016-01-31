JavaRoombots
==============

This is a little library that can act as a programmatic client for connecting to and driving [a roombot](http://roombots.riesd.com/).

To connect to the roombot simulator you would clone this repository and run a command like:

```
ant -Dchannel=YOUR_UNIQUE_CHANNEL
```

To connect to a physical roombot you can use the default channel and just point to the IP address of the roombot:

```
ant -Droomba-host=192.168.0.0.2
```

You will see a lot of output about the messages received and sent by this client so you can decide how to customize it.


## Getting Started

All depedencies have been added to the `vendor/` directory at the root of the project, so setup should be very minimal.

You'll probably want to use an IDE of your choice, but an `ant` script is provided to work with any system.


## Customizing

To customize, open up `src/Roombot.java` and begin coding the Roomba around the maze.


## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/film42/java_roombots. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](contributor-covenant.org) code of conduct.


## License

The project (minus the jars) is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
