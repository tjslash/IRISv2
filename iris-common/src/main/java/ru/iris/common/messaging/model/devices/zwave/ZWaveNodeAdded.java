package ru.iris.common.messaging.model.devices.zwave;

import ru.iris.common.devices.zwave.ZWaveDevice;

/**
 * IRISv2 Project
 * Author: Nikolay A. Viguro
 * WWW: iris.ph-systems.ru
 * E-Mail: nv@ph-systems.ru
 * Date: 19.11.13
 * Time: 11:34
 * License: GPL v3
 */
public class ZWaveNodeAdded extends ZWaveNode {

    public ZWaveNodeAdded set(ZWaveDevice device) {
        super.device = device;
        return this;
    }

    @Override
    public String toString() {
        return "ZWaveNodeAdded { node: " + super.device.getInternalName() + " }";
    }
}
