package core.patterns.behavioral.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class PackageState {
    final Package pckg;

    public abstract void processPackage();
}
