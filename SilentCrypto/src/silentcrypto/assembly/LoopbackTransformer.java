package silentcrypto.assembly;

// ----------------------------------------------------------------------------
// This file is part of SilentCrypto.
//
// SilentCrypto is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 3, or (at your option)
// any later version.
//
// SilentCrypto is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// General Public License for more details.
//
//
// Linking this library statically or dynamically with other modules is
// making a combined work based on this library.  Thus, the terms and
// conditions of the GNU General Public License cover the whole
// combination.
//
// As a special exception, the copyright holders of this library give
// you permission to link this library with independent modules to
// produce an executable, regardless of the license terms of these
// independent modules, and to copy and distribute the resulting
// executable under terms of your choice, provided that you also meet,
// for each linked independent module, the terms and conditions of the
// license of that module.  An independent module is a module which is
// not derived from or based on this library.  If you modify this
// library, you may extend this exception to your version of the
// library, but you are not obligated to do so.  If you do not wish to
// do so, delete this exception statement from your version.
// ----------------------------------------------------------------------------

import java.util.Map;

/**
 * A trivial {@link Transformer} to allow closing a chain in an {@link Assembly}.
 * This class is not visible outside this package.
 *
 * @version $Revision: 0.1 $
 */
final class LoopbackTransformer extends Transformer {

   // Constants and variables
   // -------------------------------------------------------------------------

   // Constructor(s)
   // -------------------------------------------------------------------------

   /** Trivial protected constructor. */
   LoopbackTransformer() {
      super();
   }

   // Class methods
   // -------------------------------------------------------------------------

   // Instance methods
   // -------------------------------------------------------------------------

   public void init(Map attributes) throws TransformerException {
   }

   public void reset() {
   }

   public byte[] update(byte[] in, int offset, int length)
   throws TransformerException {
      return updateDelegate(in, offset, length);
   }

   public byte[] lastUpdate() throws TransformerException {
      return lastUpdateDelegate();
   }

   // abstract methods to be implemented by concrete subclasses ---------------

   void initDelegate(Map attributes) throws TransformerException {
   }

   int delegateBlockSize() {
      return 1;
   }

   void resetDelegate() {
   }

   byte[] updateDelegate(byte[] in, int offset, int length)
   throws TransformerException {
      byte[] result = new byte[length];
      System.arraycopy(in, offset, result, 0, length);
      return result;
   }

   byte[] lastUpdateDelegate() throws TransformerException {
      return new byte[0];
   }
}
