package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public interface EquipmentService
{
   public EquipmentType[] getEquipmentTypes();
}
