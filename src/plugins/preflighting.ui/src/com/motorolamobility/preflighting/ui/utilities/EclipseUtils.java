/*
* Copyright (C) 2012 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.motorolamobility.preflighting.ui.utilities;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.dialogs.WorkbenchPreferenceDialog;


@SuppressWarnings("restriction")
public class EclipseUtils
{
    @SuppressWarnings("unchecked")
    public static void openPreference(Shell shell, String nodeID)
    {
        // Makes the network preferences dialog manager
        PreferenceManager manager = PlatformUI.getWorkbench().getPreferenceManager();
        IPreferenceNode networkNode = null;
        for (IPreferenceNode node : (List<IPreferenceNode>) manager
                .getElements(PreferenceManager.PRE_ORDER))
        {
            if (node.getId().equals(nodeID))
            {
                networkNode = node;
                break;
            }
        }
        PreferenceManager prefMan = new PreferenceManager();
        if (networkNode != null)
        {
            prefMan.addToRoot(networkNode);
        }
        PreferenceDialog preferencesDialog = new WorkbenchPreferenceDialog(shell, prefMan);
        preferencesDialog.create();
        preferencesDialog.open();
    }

}
