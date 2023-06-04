**import statement** does not bring in child packages, fields or methods; 
it imports classes **only directly under the package**.

Meaning that if it was necessary to use _AtomicInteger_,
only the following import would support this: 
```java
import java.util.concurrent.atomic.*;
```

These imports would not allow to achieve the requirement:
```java
import java.util.*;
import java.util.concurrent.*;
```