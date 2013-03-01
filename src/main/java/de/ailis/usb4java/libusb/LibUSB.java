/*
 * Copyright 2013 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 * 
 * Based on libusbx <http://libusbx.org/>:  
 * 
 * Copyright 2001 Johannes Erdfelt <johannes@erdfelt.com>
 * Copyright 2007-2008 Daniel Drake <dsd@gentoo.org>
 * Copyright 2012 Pete Batard <pete@akeo.ie>
 */

package de.ailis.usb4java.libusb;

import java.nio.IntBuffer;

/**
 * Static class providing the constants and functions of libusbx.
 */
public final class LibUSB
{
    // Log message levels.

    /** No messages ever printed by the library (default). */
    public static final int LOG_LEVEL_NONE = 0;

    /** Error messages are printed to stderr. */
    public static final int LOG_LEVEL_ERROR = 1;

    /** Warning and error messages are printed to stderr. */
    public static final int LOG_LEVEL_WARNING = 2;

    /**
     * Informational messages are printed to stdout, warning and error messages
     * are printed to stderr.
     */
    public static final int LOG_LEVEL_INFO = 3;

    /**
     * Debug and informational messages are printed to stdout, warnings and
     * errors to stderr.
     */
    public static final int LOG_LEVEL_DEBUG = 4;

    // Error codes. Most libusbx functions return 0 on success or one of these
    // codes on failure. You can call errorName() to retrieve a string
    // representation of an error code.

    /** Success (no error). */
    public static final int SUCCESS = 0;

    /** Input/output error. */
    public static final int ERROR_IO = -1;

    /** Invalid parameter. */
    public static final int ERROR_INVALID_PARAM = -2;

    /** Access denied (insufficient permissions). */
    public static final int ERROR_ACCESS = -3;

    /** No such device (it may have been disconnected). */
    public static final int ERROR_NO_DEVICE = -4;

    /** Entity not found. */
    public static final int ERROR_NOT_FOUND = -5;

    /** Resource busy. */
    public static final int ERROR_BUSY = -6;

    /** Operation timed out. */
    public static final int ERROR_TIMEOUT = -7;

    /** Overflow. */
    public static final int ERROR_OVERFLOW = -8;

    /** Pipe error. */
    public static final int ERROR_PIPE = -9;

    /** System call interrupted (perhaps due to signal) */
    public static final int ERROR_INTERRUPTED = -10;

    /** Insufficient memory. */
    public static final int ERROR_NO_MEM = -11;

    /** Operation not supported or unimplemented on this platform. */
    public static final int ERROR_NOT_SUPPORTED = -12;

    /** Other error. */
    public static final int ERROR_OTHER = -99;

    // Speed codes. Indicates the speed at which the device is operating.

    /** The OS doesn't report or know the device speed. */
    public static final int SPEED_UNKNOWN = 0;

    /** The device is operating at low speed (1.5MBit/s). */
    public static final int SPEED_LOW = 1;

    /** The device is operating at full speed (12MBit/s). */
    public static final int SPEED_FULL = 2;

    /** The device is operating at high speed (480MBit/s). */
    public static final int SPEED_HIGH = 3;

    /** The device is operating at super speed (5000MBit/s). */
    public static final int SPEED_SUPER = 4;

    // Standard requests, as defined in table 9-5 of the USB 3.0 specifications.

    /** Request status of the specific recipient. */
    public static final int REQUEST_GET_STATUS = 0x00;

    /** Clear or disable a specific feature. */
    public static final int REQUEST_CLEAR_FEATURE = 0x01;

    /** Set or enable a specific feature. */
    public static final int REQUEST_SET_FEATURE = 0x03;

    /** Set device address for all future accesses. */
    public static final int REQUEST_SET_ADDRESS = 0x05;

    /** Set device address for all future accesses. */
    public static final int REQUEST_GET_DESCRIPTOR = 0x06;

    /** Set device address for all future accesses. */
    public static final int REQUEST_SET_DESCRIPTOR = 0x07;

    /** Get the current device configuration value. */
    public static final int REQUEST_GET_CONFIGURATION = 0x08;

    /** Get the current device configuration value. */
    public static final int REQUEST_SET_CONFIGURATION = 0x09;

    /** Return the selected alternate setting for the specified interface. */
    public static final int REQUEST_GET_INTERFACE = 0x0a;

    /** Select an alternate interface for the specified interface. */
    public static final int REQUEST_SET_INTERFACE = 0x0b;

    /** Set then report an endpoint's synchronization frame. */
    public static final int REQUEST_SYNCH_FRAME = 0x0c;

    /** Sets both the U1 and U2 Exit Latency. */
    public static final int REQUEST_SET_SEL = 0x30;

    /**
     * Delay from the time a host transmits a packet to the time it is received
     * by the device.
     */
    public static final int SET_ISOCH_DELAY = 0x31;

    // Request type bits of the bmRequestType field in control transfers.

    /** Standard. */
    public static final int REQUEST_TYPE_STANDARD = 0x00 << 5;

    /** Class. */
    public static final int REQUEST_TYPE_CLASS = 0x01 << 5;

    /** Vendor. */
    public static final int REQUEST_TYPE_VENDOR = 0x02 << 5;

    /** Reserved. */
    public static final int REQUEST_TYPE_RESERVED = 0x03 << 5;

    // Recipient bits of the bmRequestType field in control transfers.
    // Values 4 through 31 are reserved.

    /** Device. */
    public static final int RECIPIENT_DEVICE = 0x00;

    /** Interface. */
    public static final int RECIPIENT_INTERFACE = 0x01;

    /** Endpoint. */
    public static final int RECIPIENT_ENDPOINT = 0x02;

    /** Other. */
    public static final int RECIPIENT_OTHER = 0x03;

    // Capabilities supported by this instance of libusb. Test if the loaded
    // library supports a given capability by calling libusb_has_capability().

    /** The libusb_has_capability() API is available. */
    public static final int CAP_HAS_CAPABILITY = 0x00;

    // Device and/or Interface Class codes.

    /**
     * In the context of a device descriptor, this bDeviceClass value indicates
     * that each interface specifies its own class information and all
     * interfaces operate independently.
     */
    public static final int CLASS_PER_INTERFACE = 0;

    /** Audio class. */
    public static final int CLASS_AUDIO = 1;

    /** Communications class. */
    public static final int CLASS_COMM = 2;

    /** Human Interface Device class. */
    public static final int CLASS_HID = 3;

    /** Physical. */
    public static final int CLASS_PHYSICAL = 5;

    /** Image class. */
    public static final int CLASS_PTP = 6;

    /** Image class. */
    public static final int CLASS_IMAGE = 6;

    /** Printer class. */
    public static final int CLASS_PRINTER = 7;

    /** Mass storage class. */
    public static final int CLASS_MASS_STORAGE = 8;

    /** Hub class. */
    public static final int CLASS_HUB = 9;

    /** Data class. */
    public static final int CLASS_DATA = 10;

    /** Smart Card. */
    public static final int CLASS_SMART_CARD = 0x0b;

    /** Content Security. */
    public static final int CLASS_CONTENT_SECURITY = 0x0d;

    /** Video. */
    public static final int CLASS_VIDEO = 0x0e;

    /** Personal Healthcare. */
    public static final int CLASS_PERSONAL_HEALTHCARE = 0x0f;

    /** Diagnostic Device. */
    public static final int CLASS_DIAGNOSTIC_DEVICE = 0xdc;

    /** Wireless class. */
    public static final int CLASS_WIRELESS = 0xe0;

    /** Application class. */
    public static final int CLASS_APPLICATION = 0xfe;

    /** Class is vendor-specific. */
    public static final int CLASS_VENDOR_SPEC = 0xff;

    // Descriptor types as defined by the USB specification.

    /**
     * Device descriptor. See libusb_device_descriptor.
     */
    public static final int DT_DEVICE = 0x01;

    /**
     * Configuration descriptor. See libusb_config_descriptor.
     */
    public static final int DT_CONFIG = 0x02;

    /** String descriptor. */
    public static final int DT_STRING = 0x03;

    /**
     * Interface descriptor.
     * 
     * See libusb_interface_descriptor.
     */
    public static final int DT_INTERFACE = 0x04;

    /**
     * Endpoint descriptor.
     * 
     * See libusb_endpoint_descriptor.
     */
    public static final int DT_ENDPOINT = 0x05;

    /** HID descriptor. */
    public static final int DT_HID = 0x21;

    /** HID report descriptor. */
    public static final int DT_REPORT = 0x22;

    /** Physical descriptor. */
    public static final int DT_PHYSICAL = 0x23;

    /** Hub descriptor. */
    public static final int DT_HUB = 0x29;

    /** Hub descriptor. */
    public static final int DT_SUPERSPEED_HUB = 0x2a;

    // Endpoint direction. Values for bit 7 of the endpoint address scheme.

    /** In: device-to-host. */
    public static final int ENDPOINT_IN = 0x80;

    /** Out: host-to-device. */
    public static final int ENDPOINT_OUT = 0x00;

    // Endpoint transfer type. Values for bits 0:1 of the endpoint attributes
    // field.

    /** Control endpoint. */
    public static final int TRANSFER_TYPE_CONTROL = 0;

    /** Isochronous endpoint. */
    public static final int TRANSFER_TYPE_ISOCHRONOUS = 1;

    /** Bulk endpoint. */
    public static final int TRANSFER_TYPE_BULK = 2;

    /** Interrupt endpoint. */
    public static final int TRANSFER_TYPE_INTERRUPT = 3;

    // Synchronization type for isochronous endpoints.
    // Values for bits 2:3 of the bmAttributes field in
    // libusb_endpoint_descriptor.

    /** No synchronization. */
    public static final int ISO_SYNC_TYPE_NONE = 0;

    /** Asynchronous. */
    public static final int ISO_SYNC_TYPE_ASYNC = 1;

    /** Adaptive. */
    public static final int ISO_SYNC_TYPE_ADAPTIVE = 2;

    /** Synchronous. */
    public static final int ISO_SYNC_TYPE_SYNC = 3;

    // Usage type for isochronous endpoints. Values for bits 4:5 of the
    // bmAttributes field in libusb_endpoint_descriptor.

    /** Data endpoint. */
    public static final int ISO_USAGE_TYPE_DATA = 0;

    /** Feedback endpoint. */
    public static final int ISO_USAGE_TYPE_FEEDBACK = 1;

    /** Implicit feedback Data endpoint. */
    public static final int ISO_USAGE_TYPE_IMPLICIT = 2;

    static
    {
        Loader.load();
    }

    /**
     * Private constructor to prevent instantiation.
     */
    private LibUSB()
    {
        // Empty
    }

    /**
     * Initialize libusb.
     * 
     * This function must be called before calling any other libusbx function.
     * 
     * If you do not provide an output location for a {@link Context}, a default
     * context will be created. If there was already a default context, it will
     * be reused (and nothing will be initialized/reinitialized).
     * 
     * @param context
     *            Optional output location for context pointer. Null to use
     *            default context. Only valid on return code 0.
     * @return 0 on success or a error code on failure.
     * 
     * @see <a
     *      href="http://libusbx.sourceforge.net/api-1.0/contexts.html">Contexts</a>
     */
    public static native int init(final Context context);

    /**
     * Deinitialize libusb.
     * 
     * Should be called after closing all open devices and before your
     * application terminates.
     * 
     * @param context
     *            The {@link Context} to deinitialize, or NULL for the default
     *            context.
     */
    public static native void exit(final Context context);

    /**
     * Set log message verbosity.
     * 
     * The default level is {@link #LOG_LEVEL_NONE}, which means no messages are
     * ever printed. If you choose to increase the message verbosity level,
     * ensure that your application does not close the stdout/stderr file
     * descriptors.
     * 
     * You are advised to use level {@link #LOG_LEVEL_WARNING}. libusbx is
     * conservative with its message logging and most of the time, will only log
     * messages that explain error conditions and other oddities. This will help
     * you debug your software.
     * 
     * If the {@link #LOG_LEVEL_DEBUG} environment variable was set when libusbx
     * was initialized, this function does nothing: the message verbosity is
     * fixed to the value in the environment variable.
     * 
     * If libusbx was compiled without any message logging, this function does
     * nothing: you'll never get any messages.
     * 
     * If libusbx was compiled with verbose debug message logging, this function
     * does nothing: you'll always get messages from all levels.
     * 
     * @param context
     *            The {@link Context} to operate on, or NULL for the default
     *            context.
     * @param level
     *            The log level to set.
     */
    public static native void setDebug(final Context context,
        final int level);

    /**
     * Returns the version of the libusbx runtime.
     * 
     * @return The version of the libusbx runtime.
     */
    public static native Version getVersion();

    /**
     * Returns a list of USB devices currently attached to the system.
     * 
     * This is your entry point into finding a USB device to operate.
     * 
     * You are expected to unreference all the devices when you are done with
     * them, and then free the list with
     * {@link #freeDeviceList(DeviceList, boolean)}. Note that
     * {@link #freeDeviceList(DeviceList, boolean)} can unref all the devices
     * for you. Be careful not to unreference a device you are about to open
     * until after you have opened it.
     * 
     * @param context
     *            The context to operate on, or NULL for the default context.
     * @param list
     *            Output location for a list of devices. Must be later freed
     *            with {@link #freeDeviceList(DeviceList, boolean)}.
     * @return The number of devices in the outputted list, or any ERROR code
     *         according to errors encountered by the backend.
     */
    public static native int getDeviceList(final Context context,
        final DeviceList list);

    /**
     * Frees a list of devices previously discovered using
     * {@link #getDeviceList(Context, DeviceList)}.
     * 
     * If the unref_devices parameter is set, the reference count of each device
     * in the list is decremented by 1.
     * 
     * @param list
     *            The list to free.
     * @param unrefDevices
     *            Whether to unref the devices in the list.
     */
    public static native void freeDeviceList(final DeviceList list,
        boolean unrefDevices);

    /**
     * Get the number of the bus that a device is connected to.
     * 
     * @param device
     *            A device.
     * @return The bus number
     */
    public static native int getBusNumber(final Device device);

    /**
     * Get the number of the port that a device is connected to.
     * 
     * @param device
     *            A device
     * @return The port number (0 if not available).
     */
    public static native int getPortNumber(final Device device);

    /**
     * Get the list of all port numbers from root for the specified device.
     * 
     * @param context
     *            The context to operate on, or NULL for the default context
     * @param device
     *            A device.
     * @param path
     *            The array that should contain the port numbers. As per the USB
     *            3.0 specs, the current maximum limit for the depth is 7.
     * @return The number of elements filled, {@link #ERROR_OVERFLOW} if the
     *         array is too small
     */
    public static native int getPortPath(final Context context,
        final Device device, byte[] path);

    /**
     * Get the the parent from the specified device [EXPERIMENTAL].
     * 
     * @param device
     *            A device
     * @return The device parent or NULL if not available. You should issue a
     *         {@link #getDeviceList(Context, DeviceList)} before calling this
     *         function and make sure that you only access the parent before
     *         issuing {@link #freeDeviceList(DeviceList, boolean)}. The reason
     *         is that libusbx currently does not maintain a permanent list of
     *         device instances, and therefore can only guarantee that parents
     *         are fully instantiated within a
     *         {@link #getDeviceList(Context, DeviceList)} -
     *         {@link #freeDeviceList(DeviceList, boolean)} block.
     */
    public static native Device getParent(final Device device);

    /**
     * Get the address of the device on the bus it is connected to.
     * 
     * @param device
     *            A device.
     * @return The device address
     */
    public static native int getDeviceAddress(final Device device);

    /**
     * Get the negotiated connection speed for a device.
     * 
     * @param device
     *            A device.
     * @return A SPEED code, where {@link #SPEED_UNKNOWN} means that the OS
     *         doesn't know or doesn't support returning the negotiated speed.
     */
    public static native int getDeviceSpeed(final Device device);

    /**
     * Convenience function to retrieve the wMaxPacketSize value for a
     * particular endpoint in the active device configuration.
     * 
     * This function was originally intended to be of assistance when setting up
     * isochronous transfers, but a design mistake resulted in this function
     * instead. It simply returns the wMaxPacketSize value without considering
     * its contents. If you're dealing with isochronous transfers, you probably
     * want {@link #getMaxIsoPacketSize(Device, int)} instead.
     * 
     * @param device
     *            A device.
     * @param endpoint
     *            Address of the endpoint in question.
     * @return the wMaxPacketSize value {@link #ERROR_NOT_FOUND} if the endpoint
     *         does not exist {@link #ERROR_OTHER} on other failure
     */
    public static native int getMaxPacketSize(final Device device, int endpoint);

    /**
     * Calculate the maximum packet size which a specific endpoint is capable
     * sending or receiving in the duration of 1 microframe.
     * 
     * Only the active configuration is examined. The calculation is based on
     * the wMaxPacketSize field in the endpoint descriptor as described in
     * section 9.6.6 in the USB 2.0 specifications.
     * 
     * If acting on an isochronous or interrupt endpoint, this function will
     * multiply the value found in bits 0:10 by the number of transactions per
     * microframe (determined by bits 11:12). Otherwise, this function just
     * returns the numeric value found in bits 0:10.
     * 
     * This function is useful for setting up isochronous transfers, for example
     * you might pass the return value from this function to
     * libusb_set_iso_packet_lengths() in order to set the length field of every
     * isochronous packet in a transfer.
     * 
     * TODO Link to libusb_set_iso_packet_lengths when implemented
     * 
     * @param device
     *            A device.
     * @param endpoint
     *            Address of the endpoint in question.
     * @return The maximum packet size which can be sent/received on this
     *         endpoint {@link #ERROR_NOT_FOUND} if the endpoint does not exist
     *         {@link #ERROR_OTHER} on other failure.
     */
    public static native int getMaxIsoPacketSize(final Device device,
        int endpoint);

    /**
     * Increment the reference count of a device.
     * 
     * @param device
     *            The device to reference.
     * @return The same device.
     */
    public static native Device refDevice(final Device device);

    /**
     * Decrement the reference count of a device.
     * 
     * If the decrement operation causes the reference count to reach zero, the
     * device shall be destroyed.
     * 
     * @param device
     *            the device to unreference.
     */
    public static native void unrefDevice(final Device device);

    /**
     * Open a device and obtain a device handle.
     * 
     * A handle allows you to perform I/O on the device in question.
     * 
     * Internally, this function adds a reference to the device and makes it
     * available to you through {@link #getDevice(DeviceHandle)}. This reference
     * is removed during {@link #close(DeviceHandle)}.
     * 
     * This is a non-blocking function; no requests are sent over the bus.
     * 
     * @param device
     *            The device to open.
     * @param handle
     *            Output location for the returned device handle pointer. Only
     *            populated when the return code is 0.
     * @return 0 on success {@link #ERROR_NO_MEM} on memory allocation failure
     *         {@link #ERROR_ACCESS} if the user has insufficient permissions
     *         {@link #ERROR_NO_DEVICE} if the device has been disconnected
     *         another error on other failure
     */
    public static native int open(final Device device, final DeviceHandle handle);

    /**
     * Convenience function for finding a device with a particular
     * idVendor/idProduct combination.
     * 
     * This function is intended for those scenarios where you are using libusbx
     * to knock up a quick test application - it allows you to avoid calling
     * {@link #getDeviceList(Context, DeviceList)} and worrying about
     * traversing/freeing the list.
     * 
     * This function has limitations and is hence not intended for use in real
     * applications: if multiple devices have the same IDs it will only give you
     * the first one, etc.
     * 
     * @param context
     *            The context to operate on, or NULL for the default context.
     * @param vendorId
     *            The idVendor value to search for.
     * @param productId
     *            The idProduct value to search for.
     * @return A handle for the first found device, or NULL on error or if the
     *         device could not be found.
     */
    public static native DeviceHandle openDeviceWithVidPid(
        final Context context, final int vendorId, final int productId);

    /**
     * Close a device handle.
     * 
     * Should be called on all open handles before your application exits.
     * 
     * Internally, this function destroys the reference that was added by
     * {@link #open(Device, DeviceHandle)} on the given device.
     * 
     * This is a non-blocking function; no requests are sent over the bus.
     * 
     * @param handle
     *            The handle to close.
     */
    public static native void close(final DeviceHandle handle);

    /**
     * Get the underlying device for a handle.
     * 
     * This function does not modify the reference count of the returned device,
     * so do not feel compelled to unreference it when you are done.
     * 
     * @param handle
     *            a device handle.
     * @return The underlying device.
     */
    public static native Device getDevice(final DeviceHandle handle);

    /**
     * Determine the bConfigurationValue of the currently active configuration.
     * 
     * You could formulate your own control request to obtain this information,
     * but this function has the advantage that it may be able to retrieve the
     * information from operating system caches (no I/O involved).
     * 
     * If the OS does not cache this information, then this function will block
     * while a control transfer is submitted to retrieve the information.
     * 
     * This function will return a value of 0 in the config output parameter if
     * the device is in unconfigured state.
     * 
     * @param handle
     *            a device handle.
     * @param config
     *            output location for the bConfigurationValue of the active
     *            configuration (only valid for return code 0)
     * @return 0 on success {@link #ERROR_NO_DEVICE} if the device has been
     *         disconnected another error code on other failure
     */
    public static native int getConfiguration(final DeviceHandle handle,
        final IntBuffer config);

    /**
     * Set the active configuration for a device.
     * 
     * The operating system may or may not have already set an active
     * configuration on the device. It is up to your application to ensure the
     * correct configuration is selected before you attempt to claim interfaces
     * and perform other operations.
     * 
     * If you call this function on a device already configured with the
     * selected configuration, then this function will act as a lightweight
     * device reset: it will issue a SET_CONFIGURATION request using the current
     * configuration, causing most USB-related device state to be reset
     * (altsetting reset to zero, endpoint halts cleared, toggles reset).
     * 
     * You cannot change/reset configuration if your application has claimed
     * interfaces - you should free them with
     * {@link #releaseInterface(DeviceHandle, int)} first. You cannot
     * change/reset configuration if other applications or drivers have claimed
     * interfaces.
     * 
     * A configuration value of -1 will put the device in unconfigured state.
     * The USB specifications state that a configuration value of 0 does this,
     * however buggy devices exist which actually have a configuration 0.
     * 
     * You should always use this function rather than formulating your own
     * SET_CONFIGURATION control request. This is because the underlying
     * operating system needs to know when such changes happen.
     * 
     * This is a blocking function.
     * 
     * @param handle
     *            a device handle.
     * @param config
     *            the bConfigurationValue of the configuration you wish to
     *            activate, or -1 if you wish to put the device in unconfigured
     *            state
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the requested
     *         configuration does not exist, {@link #ERROR_BUSY} if interfaces
     *         are currently claimed, {@link #ERROR_NO_DEVICE} if the device has
     *         been disconnected, another error code on other failure
     */
    public static native int setConfiguration(final DeviceHandle handle,
        final int config);

    /**
     * Claim an interface on a given device handle.
     * 
     * You must claim the interface you wish to use before you can perform I/O
     * on any of its endpoints.
     * 
     * It is legal to attempt to claim an already-claimed interface, in which
     * case libusbx just returns 0 without doing anything.
     * 
     * Claiming of interfaces is a purely logical operation; it does not cause
     * any requests to be sent over the bus. Interface claiming is used to
     * instruct the underlying operating system that your application wishes to
     * take ownership of the interface.
     * 
     * This is a non-blocking function.
     * 
     * @param handle
     *            A device handle.
     * @param iface
     *            The bInterfaceNumber of the interface you wish to claim.
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the requested interface
     *         does not exist, {@link #ERROR_BUSY} if another program or driver
     *         has claimed the interface, {@link #ERROR_NO_DEVICE} if the device
     *         has been disconnected, another error code on other failure
     */
    public static native int claimInterface(final DeviceHandle handle,
        final int iface);

    /**
     * Release an interface previously claimed with
     * {@link #claimInterface(DeviceHandle, int)}.
     * 
     * You should release all claimed interfaces before closing a device handle.
     * 
     * This is a blocking function. A SET_INTERFACE control request will be sent
     * to the device, resetting interface state to the first alternate setting.
     * 
     * @param handle
     *            a device handle.
     * @param iface
     *            The bInterfaceNumber of the previously-claimed interface
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the interface was not
     *         claimed, {@link #ERROR_NO_DEVICE} if the device has been
     *         disconnected, another ERROR code on other failure
     */
    public static native int releaseInterface(final DeviceHandle handle,
        final int iface);

    /**
     * Activate an alternate setting for an interface.
     * 
     * The interface must have been previously claimed with
     * {@link #claimInterface(DeviceHandle, int)}.
     * 
     * You should always use this function rather than formulating your own
     * SET_INTERFACE control request. This is because the underlying operating
     * system needs to know when such changes happen.
     * 
     * This is a blocking function.
     * 
     * @param handle
     *            A device handle.
     * @param interfaceNumber
     *            The bInterfaceNumber of the previously-claimed interface
     * @param alternateSetting
     *            The bAlternateSetting of the alternate setting to activate
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the interface was not
     *         claimed, or the requested alternate setting does not exist
     *         {@link #ERROR_NO_DEVICE} if the device has been disconnected,
     *         another ERROR code on other failure
     */
    public static native int setInterfaceAltSetting(final DeviceHandle handle,
        int interfaceNumber, int alternateSetting);

    /**
     * Clear the halt/stall condition for an endpoint.
     * 
     * Endpoints with halt status are unable to receive or transmit data until
     * the halt condition is stalled.
     * 
     * You should cancel all pending transfers before attempting to clear the
     * halt condition.
     * 
     * This is a blocking function.
     * 
     * @param handle
     *            A device handle.
     * @param endpoint
     *            The endpoint to clear halt status
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the endpoint does not
     *         exist, {@link #ERROR_NO_DEVICE} if the device has been
     *         disconnected, another ERROR code on other failure.
     */
    public static native int clearHalt(final DeviceHandle handle, int endpoint);

    /**
     * Perform a USB port reset to reinitialize a device.
     * 
     * The system will attempt to restore the previous configuration and
     * alternate settings after the reset has completed.
     * 
     * If the reset fails, the descriptors change, or the previous state cannot
     * be restored, the device will appear to be disconnected and reconnected.
     * This means that the device handle is no longer valid (you should close
     * it) and rediscover the device. A return code of {@link #ERROR_NOT_FOUND}
     * indicates when this is the case.
     * 
     * This is a blocking function which usually incurs a noticeable delay.
     * 
     * @param handle
     *            a handle of the device to reset
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if re-enumeration is
     *         required, or if the device has been disconnected another ERROR
     *         code on other failure
     */
    public static native int resetDevice(final DeviceHandle handle);

    /**
     * Determine if a kernel driver is active on an interface.
     * 
     * If a kernel driver is active, you cannot claim the interface, and libusbx
     * will be unable to perform I/O.
     * 
     * This functionality is not available on Windows.
     * 
     * @param handle
     *            A device handle.
     * @param interfaceNumber
     *            The interface to check.
     * @return 0 if no kernel driver is active, 1 if a kernel driver is active,
     *         {@link #ERROR_NO_DEVICE} if the device has been disconnected,
     *         {@link #ERROR_NOT_SUPPORTED} on platforms where the functionality
     *         is not available, another ERROR code on other failure
     * 
     * @see #detachKernelDriver(DeviceHandle, int)
     */
    public static native int kernelDriverActive(final DeviceHandle handle,
        final int interfaceNumber);

    /**
     * Detach a kernel driver from an interface.
     * 
     * If successful, you will then be able to claim the interface and perform
     * I/O.
     * 
     * This functionality is not available on Darwin or Windows.
     * 
     * Note that libusbx itself also talks to the device through a special
     * kernel driver, if this driver is already attached to the device, this
     * call will not detach it and return {@link #ERROR_NOT_FOUND}.
     * 
     * @param handle
     *            a device handle
     * @param interfaceNumber
     *            the interface to detach the driver from
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if no kernel driver was
     *         active, {@link #ERROR_INVALID_PARAM} if the interface does not
     *         exist, {@link #ERROR_NO_DEVICE} if the device has been
     *         disconnected, {@link #ERROR_NOT_SUPPORTED} on platforms where the
     *         functionality is not available, another ERROR code on other
     *         failure
     * 
     * @see #kernelDriverActive(DeviceHandle, int)
     */
    public static native int detachKernelDriver(final DeviceHandle handle,
        final int interfaceNumber);

    /**
     * Re-attach an interface's kernel driver, which was previously detached
     * using {@link #detachKernelDriver(DeviceHandle, int)}.
     * 
     * This call is only effective on Linux and returns
     * {@link #ERROR_NOT_SUPPORTED} on all other platforms.
     * 
     * This functionality is not available on Darwin or Windows.
     * 
     * @param handle
     *            A device handle
     * @param interfaceNumber
     *            the interface to attach the driver from
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if no kernel driver was
     *         active, {@link #ERROR_INVALID_PARAM} if the interface does not
     *         exist, {@link #ERROR_NO_DEVICE} if the device has been
     *         disconnected, {@link #ERROR_NOT_SUPPORTED} on platforms where the
     *         functionality is not available, {@link #ERROR_BUSY} if the driver
     *         cannot be attached because the interface is claimed by a program
     *         or driver, anotherERROR code on other failure
     * 
     * @see #kernelDriverActive(DeviceHandle, int)
     */
    public static native int attachKernelDriver(final DeviceHandle handle,
        final int interfaceNumber);

    /**
     * Check at runtime if the loaded library has a given capability.
     * 
     * @param capability
     *            The capability to check for.
     * @return True if the running library has the capability, false otherwise.
     */
    public static native boolean hasCapability(final int capability);

    /**
     * Returns a string with the ASCII name of a libusb error or transfer status
     * code.
     * 
     * @param errorCode
     *            The libusb error or libusb transfer status code to return the
     *            name of.
     * @return The error name, or the string **UNKNOWN** if the value of
     *         errorCode is not a known error / status code.
     */
    public static native String errorName(final int errorCode);

    /**
     * Convert a 16-bit value from little-endian to host-endian format.
     * 
     * On little endian systems, this function does nothing. On big endian
     * systems, the bytes are swapped.
     * 
     * @param x
     *            The little-endian value to convert
     * @return the value in host-endian byte order
     */
    public static native int le16ToCpu(final int x);

    /**
     * Convert a 16-bit value from host-endian to little-endian format.
     * 
     * On little endian systems, this function does nothing. On big endian
     * systems, the bytes are swapped.
     * 
     * @param x
     *            The host-endian value to convert
     * @return the value in little-endian byte order
     */
    public static native int cpuToLe16(final int x);

    /**
     * Get the USB device descriptor for a given device.
     * 
     * This is a non-blocking function; the device descriptor is cached in
     * memory.
     * 
     * @param device
     *            the device
     * @param descriptor
     *            output location for the descriptor data
     * @return 0 on success or a ERROR code on failure
     */
    public static native int getDeviceDescriptor(final Device device,
        final DeviceDescriptor descriptor);

    /**
     * Retrieve a string descriptor in C style ASCII.
     * 
     * @param handle
     *            A device handle.
     * @param index
     *            The index of the descriptor to retrieve.
     * @param string
     *            Output buffer for ASCII string descriptor.
     * @param length
     *            Maximum number of bytes to read.
     * @return Number of bytes returned in data, or ERROR code on failure.
     */
    public static native int getStringDescriptorAscii(
        final DeviceHandle handle, final int index, final StringBuffer string,
        final int length);

    /**
     * A simple wrapper around
     * {@link #getStringDescriptorAscii(DeviceHandle, int, StringBuffer, int)}
     * Simply returns the string (Maximum length of 256) if possible. If not
     * possible (NULL handle or 0-index specified or error occured) then null is
     * returned.
     * 
     * This method is not part of libusb.
     * 
     * @param handle
     *            The device handle.
     * @param index
     *            The string descriptor index.
     * @return The string or null if it could not be read.
     */
    public static String getStringDescriptor(final DeviceHandle handle,
        final int index)
    {
        if (handle == null || index == 0) return null;
        StringBuffer buffer = new StringBuffer();
        if (getStringDescriptorAscii(handle, index, buffer, 256) >= 0)
            return buffer.toString();
        return null;
    }

    /**
     * Get the USB configuration descriptor for the currently active
     * configuration.
     * 
     * This is a non-blocking function which does not involve any requests being
     * sent to the device.
     * 
     * @param device
     *            A device.
     * @param descriptor
     *            Output location for the USB configuration descriptor. Only
     *            valid if 0 was returned. Must be freed with
     *            {@link #freeConfigDescriptor(ConfigDescriptor)} after use.
     * @return 0 on success, {@link #ERROR_NOT_FOUND} if the device is in
     *         unconfigured state another ERROR code on error
     * 
     * @see #getConfigDescriptor(Device, int, ConfigDescriptor)
     */
    public static native int getActiveConfigDescriptor(final Device device,
        final ConfigDescriptor descriptor);

    /**
     * Get a USB configuration descriptor based on its index.
     * 
     * This is a non-blocking function which does not involve any requests being
     * sent to the device.
     * 
     * @param device
     *            A device.
     * @param index
     *            The index of the configuration you wish to retrieve
     * @param descriptor
     *            Output location for the USB configuration descriptor. Only
     *            valid if 0 was returned. Must be freed with
     *            {@link #freeConfigDescriptor(ConfigDescriptor)} after use.
     * @return 0 on success {@link #ERROR_NOT_FOUND} if the configuration does
     *         not exist another ERROR code on error.
     * 
     * @see #getActiveConfigDescriptor(Device, ConfigDescriptor)
     * @see #getConfigDescriptorByValue(Device, int, ConfigDescriptor)
     */
    public static native int getConfigDescriptor(final Device device,
        final int index, final ConfigDescriptor descriptor);

    /**
     * Get a USB configuration descriptor with a specific bConfigurationValue.
     * 
     * This is a non-blocking function which does not involve any requests being
     * sent to the device.
     * 
     * @param device
     *            A device.
     * @param value
     *            The bConfigurationValue of the configuration you wish to
     *            retrieve.
     * @param descriptor
     *            Output location for the USB configuration descriptor. Only
     *            valid if 0 was returned. Must be freed with
     *            libusb_free_config_descriptor() after use.
     * @return 0 on success {@link #ERROR_NOT_FOUND} if the configuration does
     *         not exist another ERROR code on error See also:
     * 
     * @see #getActiveConfigDescriptor(Device, ConfigDescriptor)
     * @see #getConfigDescriptor(Device, int, ConfigDescriptor)
     */
    public static native int getConfigDescriptorByValue(final Device device,
        final int value, final ConfigDescriptor descriptor);

    /**
     * Free a configuration descriptor obtained from
     * {@link #getConfigDescriptor(Device, int, ConfigDescriptor)} or
     * {@link #getActiveConfigDescriptor(Device, ConfigDescriptor)}.
     * 
     * It is safe to call this function with a NULL config parameter, in which
     * case the function simply returns.
     * 
     * @param descriptor
     *            The configuration descriptor to free
     */
    public static native void freeConfigDescriptor(
        final ConfigDescriptor descriptor);
}
