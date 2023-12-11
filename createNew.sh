#!/bin/bash

if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <name>"
  exit 1
fi



input=$1
package_name=$(echo "${input}" | tr -d ' ' | tr '[:upper:]' '[:lower:]')
method_name=$(echo "${input}" | tr -d ' ')
directory_name="./src/main/java/solution/${package_name}"

# Create directory
mkdir -p "${directory_name}"


# Create Java file with class and method
cat > "${directory_name}/Solution.java" << EOF
package solution.$package_name;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    public static void $method_name() {
        //write your code here;
    }
}
EOF

echo "Java file created successfully: ${directory_name}/Solution.java"