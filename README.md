### Objective

Your challenge is to build out this Android invoicing app for Atlys's accounting department and implement all functionality outlined in the **Expected Behaviour** section.

### Brief

Your task is to build out the project to the design files provided in the `/designs` folder. The functionality outlined in **Expected Behaviour** is more important than implementing the designs pixel-perfect.

All the required assets for this project are in the `/assets` folder. The assets are already exported for the correct screen size and optimized.

The design system file will give you more information about the various colors, fonts, and styles used in this project.

We provide the data in a local `data.json` file, so use that to populate the content on first load.

### Tasks

Your users should be able to:

- View the optimal layout for the app depending on their device's screen size
- Create, read, update, and delete invoices
- **Bonus**: Receive form validations when trying to create/edit an invoice
- **Bonus**: Save draft invoices, and mark pending invoices as paid
- **Bonus**: Filter invoices by status (draft/pending/paid)

### Expected Behaviour

- Creating an invoice
  - When creating a new invoice, an ID needs to be created. Each ID should be 2 random uppercased letters followed by 4 random numbers.
  - Invoices can be created either as drafts or as pending. Tapping on "Save as Draft" should allow the user to leave any form field blank, but should create an ID if one doesn't exist and set the status to "draft". Tapping on "Save & Send" should require all form fields to be filled in, and should set the status to "pending".
  - Changing the Payments Terms field should set the `paymentDue` property based on the `createdAt` date plus the numbers of days set for the payment terms.
  - The `total` should be the sum of all items on the invoice.
- Editing an invoice
  - When saving changes to an invoice, all fields are required when the "Save Changes" button is tapped. If the user taps on "Cancel", any unsaved changes should be reset.
  - If the invoice being edited is a "draft", the status needs to be updated to "pending" when the "Save Changes" button is tapped. All fields are required at this stage.
- Users should be able to mark invoices as paid by tapping on the "Mark as Paid" button. This should change the invoice's status to "paid".
- Users should receive a confirmation modal when trying to delete invoices.
- Feel free not to add custom styling for the date and dropdown form fields. The designs for those fields are optional extras and are mostly for illustration purposes.

### Deliverables

For iOS, include an assignment.zip file containing your compressed .app bundle **in the root of the repository**.
Your .app bundle must represent a simulator build of your app. After running in iOS Simulator via Xcode, look in ~/Library/Developer/Xcode/DerivedData/<project-name>/Build/Products/Debug-iphonesimulator/.
Alternatively, you may run xcodebuild -sdk iphonesimulator (if you use .xcodeproj) or xcodebuild -sdk iphonesimulator -workspace Sample.xcworkspace/ -scheme <your-scheme> -configuration Debug (if you use .xcworkspace) in your project directory, then zip the .app bundle in build/Debug-iphonesimulator/.

For Android, include assignment.apk containing your app **in the root of the repository**.
After your app is built, either via Android Studio or by running the command ./gradlew assembleDebug in your project directory, look in <project-name>/<module-name>/build/outputs/apk/.

### Evaluation Criteria

- **Android** best practices
- Show us your work through your commit history
- We're looking for you to produce working code, with enough room to demonstrate how to structure components in a small program
- Completeness: did you complete the features?
- Correctness: does the functionality act in sensible, thought-out ways?
- Maintainability: is it written in a clean, maintainable way?
- Testing: is the system adequately tested?

### CodeSubmit

Please organize, design, test and document your code as if it were going into production - then push your changes to the master branch. After you have pushed your code, you may submit the assignment on the assignment page.

**Have fun building!** 🚀

The Atlys Team