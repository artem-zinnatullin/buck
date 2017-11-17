/*
 * Copyright 2017-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.cxx.toolchain.linker;

import com.facebook.buck.rules.args.Arg;
import java.nio.file.Path;

/**
 * A windows shared library consists of two files: (1) a dll to be used at runtime and (2) an import
 * library (static library) to be used to link against a given shared library. Wnen creating a dll,
 * link.exe produces a dll file and a corresponding import library file. This interface represents
 * those concepts.
 */
public interface HasImportLibrary {

  /**
   * @return the platform-specific way to generate an implib file.
   * @param output the path of the output binary
   */
  Iterable<Arg> importLibrary(Path output);

  /**
   * @return the path of the output binary's link-map file generated by the linker.
   * @param output the path of the output binary
   */
  Path importLibraryPath(Path output);
}